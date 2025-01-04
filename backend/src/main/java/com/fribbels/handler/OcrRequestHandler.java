package com.fribbels.handler;

import com.fribbels.Main;
import com.fribbels.enums.Set;
import com.fribbels.request.IdRequest;
import com.fribbels.request.Ocr2Request;
import com.fribbels.response.OcrResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.tesseract.TessBaseAPI;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.bytedeco.leptonica.global.leptonica.pixDestroy;
import static org.bytedeco.leptonica.global.leptonica.pixRead;

/**
 * OcrRequestHandler is a subclass of {@link RequestHandler} and implements the
 * {@link HttpHandler} interface.
 * This class is responsible for handling OCR-related HTTP requests, processing
 * images, and extracting relevant data
 * using the Tesseract OCR engine. It handles the OCR request based on the
 * provided path and returns OCR results
 * in JSON format.
 *
 * <p>
 * It supports two types of OCR requests:
 * <ul>
 * <li>/ocr: Processes the OCR for a single image based on the provided ID.</li>
 * <li>/ocr2: Processes OCR for an image with debug information, such as
 * enhanced levels and substats.</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class provides methods to initialize the Tesseract OCR engine, handle
 * OCR requests, and send responses
 * back to the client.
 * </p>
 */
public class OcrRequestHandler extends RequestHandler implements HttpHandler {

    private TessBaseAPI tessBaseAPI;
    private static final int ENCHANCE_BUFFER_X = 50;
    private static final int ENCHANCE_BUFFER_Y = 150;

    private static boolean initialized = false;

    public OcrRequestHandler() throws Exception {
    }

    /**
     * Initializes the Tesseract OCR engine with required configurations.
     * It sets up the path to the trained data and configures several variables for
     * OCR processing.
     * 
     * @throws Exception if the Tesseract OCR engine could not be initialized.
     */
    private void initialize() throws Exception {
        final String path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getParentFile().getParentFile().getParentFile().getPath();

        tessBaseAPI = new TessBaseAPI();
        if (tessBaseAPI.Init(path + "/data/tessdata/eng.traineddata", "eng", 0) != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        tessBaseAPI.SetVariable("load_system_dawg", "false");
        tessBaseAPI.SetVariable("load_freq_dawg", "false");
        tessBaseAPI.SetVariable("classify_enable_learning", "0");
        tessBaseAPI.SetVariable("user_defined_dpi", "70");
        initialized = true;
    }

    /**
     * Handles HTTP requests for OCR processing.
     * This method processes requests from the client, determines the path, and
     * routes the request
     * to the appropriate handler.
     *
     * @param exchange The HTTP exchange object containing the request and response
     *                 details.
     * @throws IOException if an I/O error occurs while handling the HTTP request.
     */
    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        System.out.println("===================== ItemsRequestHandler =====================");
        final String path = exchange.getRequestURI().getPath();

        System.out.println("Path: " + path);

        try {
            if (!initialized) {
                initialize();
            }

            switch (path) {
                case "/ocr":
                    final IdRequest ocrRequest = parseRequest(exchange, IdRequest.class);
                    sendResponse(exchange, handleOcrRequest(ocrRequest));
                    return;
                case "/ocr2":
                    final Ocr2Request ocr2Request = parseRequest(exchange, Ocr2Request.class);
                    sendResponse(exchange, handleOcr2Request(ocr2Request));
                    return;
                default:
                    System.out.println("No handler found for " + path);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

        sendResponse(exchange, "ERROR");
    }

    /**
     * Handles OCR requests for the "/ocr" path.
     * This method processes the OCR request, extracts relevant data from an image,
     * and returns the result.
     *
     * @param idRequest The request containing the ID of the image to process.
     * @return The OCR result as a JSON string.
     */
    private String handleOcrRequest(final IdRequest idRequest) {
        final String filename = idRequest.getId();
        final PIX image = pixRead(filename);

        tessBaseAPI.SetImage(image);

        final Set set = readSet();
        final String title;
        final String main;

        if (isShiftedSet(set)) {
            title = readShiftedTitle();
            main = readShiftedMain();
        } else {
            title = readTitle();
            main = readMain();
        }

        // Get OCR result
        final OcrResponse ocrResponse = OcrResponse.builder()
                .title(title)
                .main(main)
                .set(set.getName())
                .build();

        System.out.println(ocrResponse);

        pixDestroy(image);
        return toJson(ocrResponse);
    }

    /**
     * Handles OCR requests for the "/ocr2" path.
     * This method processes the OCR request, extracts enhancement, level, and
     * substats data from images,
     * and returns the result.
     *
     * @param request The request containing the OCR2 data.
     * @return The OCR result as a JSON string.
     */
    private String handleOcr2Request(final Ocr2Request request) {
        final String levelFilename = request.getId() + "debugLevel.png";
        final String substatsFilename = request.getId() + "debugSubstats.png";
        final PIX levelImage = pixRead(levelFilename);
        final PIX substatsImage = pixRead(substatsFilename);

        tessBaseAPI.SetImage(levelImage);

        final String enhance;
        final String level;
        final String substatsText;
        final String substatsNumbers;

        if (request.getShifted()) {
            enhance = readShiftedEnhance();
            level = readShiftedLevel();
        } else {
            enhance = readEnhance();
            level = readLevel();
        }

        tessBaseAPI.SetImage(substatsImage);

        if (request.getShifted()) {
            substatsText = readShiftedSubstatsText();
            substatsNumbers = readShiftedSubstatsNumbers();
        } else {
            substatsText = readSubstatsText();
            substatsNumbers = readSubstatsNumbers();
        }

        final OcrResponse ocrResponse = OcrResponse.builder()
                .enhance(enhance)
                .level(level)
                .substatsText(substatsText)
                .substatsNumbers(substatsNumbers)
                .build();

        System.out.println(ocrResponse);

        pixDestroy(levelImage);
        pixDestroy(substatsImage);
        return toJson(ocrResponse);
    }

    /**
     * Reads the title text from a specific rectangular area on the image using OCR.
     *
     * @return The extracted title text as a String.
     */
    private String readTitle() {
        setText();
        return readRectangle(177, 185, 234, 170);
    }

    /**
     * Reads the enhancement value from a specific rectangular area on the image
     * using OCR.
     * This area is adjusted by `ENCHANCE_BUFFER_X` and `ENCHANCE_BUFFER_Y` values.
     *
     * @return The extracted enhancement value as a String.
     */
    private String readEnhance() {
        setNumbersAndPlus();
        return readRectangle(132 - ENCHANCE_BUFFER_X, 198 - ENCHANCE_BUFFER_Y, 40, 19);
    }

    /**
     * Reads the level value from a specific rectangular area on the image using
     * OCR.
     * This area is adjusted by `ENCHANCE_BUFFER_X` and `ENCHANCE_BUFFER_Y` values.
     *
     * @return The extracted level value as a String.
     */
    private String readLevel() {
        setNumbers();
        return readRectangle(65 - ENCHANCE_BUFFER_X, 212 - ENCHANCE_BUFFER_Y, 25, 19);
    }

    /**
     * Reads the main stats or other relevant data from a specific rectangular area
     * on the image using OCR.
     *
     * @return The extracted main stats text as a String.
     */
    private String readMain() {
        setNumbersAndTextAndPercentAndComma();
        return readRectangle(85, 370, 318, 53);
    }

    /**
     * Reads the substats text from a specific rectangular area on the image using
     * OCR.
     *
     * @return The extracted substats text as a String.
     */
    private String readSubstatsText() {
        setText();
        return readRectangle(0, 193, 1000, 580);
    }

    /**
     * Reads the substats numbers from a specific rectangular area on the image
     * using OCR.
     *
     * @return The extracted substats numbers as a String.
     */
    private String readSubstatsNumbers() {
        setNumbersAndPercentAndComma();
        return readRectangle(1041, 185, 354, 553);
    }

    /**
     * Reads the shifted title text from a specific rectangular area on the image
     * using OCR.
     *
     * @return The extracted shifted title text as a String.
     */
    private String readShiftedTitle() {
        setText();
        return readRectangle(176, 160, 236, 170);
    }

    /**
     * Reads the shifted enhancement value from a specific rectangular area on the
     * image using OCR.
     * This area is adjusted by `ENCHANCE_BUFFER_X` and `ENCHANCE_BUFFER_Y` values.
     *
     * @return The extracted shifted enhancement value as a String.
     */
    private String readShiftedEnhance() {
        setNumbersAndPlus();
        return readRectangle(132 - ENCHANCE_BUFFER_X, 173 - ENCHANCE_BUFFER_Y, 39, 20);
    }

    /**
     * Reads the shifted level value from a specific rectangular area on the image
     * using OCR.
     * This area is adjusted by `ENCHANCE_BUFFER_X` and `ENCHANCE_BUFFER_Y` values.
     *
     * @return The extracted shifted level value as a String.
     */
    private String readShiftedLevel() {
        setNumbers();
        return readRectangle(65 - ENCHANCE_BUFFER_X, 188 - ENCHANCE_BUFFER_Y, 27, 18);
    }

    /**
     * Reads the shifted main stats or other relevant data from a specific
     * rectangular area on the image using OCR.
     *
     * @return The extracted shifted main stats text as a String.
     */
    private String readShiftedMain() {
        setNumbersAndTextAndPercentAndComma();
        return readRectangle(84, 342, 323, 69);
    }

    /**
     * Reads the shifted substats text from a specific rectangular area on the image
     * using OCR.
     *
     * @return The extracted shifted substats text as a String.
     */
    private String readShiftedSubstatsText() {
        setText();
        return readRectangle(0, 100, 1000, 567);
    }

    /**
     * Reads the shifted substats numbers from a specific rectangular area on the
     * image using OCR.
     *
     * @return The extracted shifted substats numbers as a String.
     */
    private String readShiftedSubstatsNumbers() {
        setNumbersAndPercentAndComma();
        return readRectangle(1034, 108, 339, 524);
    }

    /**
     * Reads the set from the image by comparing the extracted text to the available
     * set names.
     * Uses Levenshtein distance to determine the closest match.
     *
     * @return The closest matching set based on the extracted text.
     */
    private Set readSet() {
        setText();
        final String text = readRectangle(100, 572, 250, 69);

        final Map<Set, Integer> distances = Stream.of(Set.values()).collect(Collectors.toMap(
                x -> x,
                x -> calculateLevenshteinDistance(x.getName(), text)));

        return distances.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .orElse(new AbstractMap.SimpleEntry<>(Set.SPEED, 0))
                .getKey();
    }

    /**
     * Calculates the Levenshtein distance between two strings.
     * 
     * @param source The source string.
     * @param target The target string.
     * @return The Levenshtein distance between the source and target.
     */
    private int calculateLevenshteinDistance(String source, String target) {
        int sourceLength = source.length();
        int targetLength = target.length();

        int[][] dp = new int[sourceLength + 1][targetLength + 1];

        for (int i = 0; i <= sourceLength; i++) {
            for (int j = 0; j <= targetLength; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (source.charAt(i - 1) == target.charAt(j - 1)) ? 0 : 1;

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }

        return dp[sourceLength][targetLength];
    }

    /**
     * Reads the text from a specific rectangular area on the image using OCR.
     * This function uses the Tesseract API to extract text within the defined
     * rectangle.
     *
     * @param x The x-coordinate of the top-left corner of the rectangle.
     * @param y The y-coordinate of the top-left corner of the rectangle.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     * @return The text extracted from the rectangle as a String.
     */
    private String readRectangle(final int x, final int y, final int w, final int h) {
        final BytePointer outText;

        // Set the rectangle for OCR
        tessBaseAPI.SetRectangle(x, y, w, h);

        // Get the text from the rectangle using Tesseract OCR
        outText = tessBaseAPI.GetUTF8Text();

        // Convert the output text to a String
        final String text = outText.getString();

        // Deallocate the memory used by the OCR result
        outText.deallocate();

        return text;
    }

    /**
     * Determines if the given set is considered a "shifted set," which refers to
     * special sets that have
     * specific rules or properties in the context of the application.
     *
     * @param set The set to check.
     * @return True if the set is one of the "shifted sets" (REVENGE, INJURY,
     *         PENETRATION, IMMUNITY), false otherwise.
     */
    private boolean isShiftedSet(final Set set) {
        return set == Set.REVENGE
                || set == Set.INJURY
                || set == Set.PENETRATION
                || set == Set.IMMUNITY;
    }

    private void setNumbers() {
        tessBaseAPI.SetVariable("tessedit_char_whitelist", "0123456789");
    }

    private void setNumbersAndPercentAndComma() {
        tessBaseAPI.SetVariable("tessedit_char_whitelist", "0123456789%,");
    }

    private void setNumbersAndPlus() {
        tessBaseAPI.SetVariable("tessedit_char_whitelist", "0123456789+");
    }

    private void setNumbersAndTextAndPercentAndComma() {
        tessBaseAPI.SetVariable("tessedit_char_whitelist",
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789%,");
    }

    private void setText() {
        tessBaseAPI.SetVariable("tessedit_char_whitelist", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
