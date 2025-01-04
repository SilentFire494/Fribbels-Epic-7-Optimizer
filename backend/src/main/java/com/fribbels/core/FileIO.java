package com.fribbels.core;

import com.fribbels.model.HeroStats;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * The {@code FileIO} class provides methods for reading and writing files.
 */
public class FileIO {

    private static final Gson GSON = new Gson();
    private static final String RESPONSE_FILE = "response.txt";

    /**
     * Reads the contents of a file into a string.
     *
     * @param filename the path to the file to read.
     * @return the file content as a string.
     * @throws IOException if an error occurs during file reading.
     */
    public String readFile(final String filename) throws IOException {
        final File requestFile = new File(filename);
        return Files.asCharSource(requestFile, StandardCharsets.UTF_8).read();
    }

    /**
     * Writes the given data to the default response file.
     *
     * @param data the data to write.
     * @throws IOException if an error occurs during file writing.
     */
    public void writeFile(final String data) throws IOException {
        final File responseFile = new File(RESPONSE_FILE);
        Files.asCharSink(responseFile, StandardCharsets.UTF_8).write(data);
    }

    /**
     * Writes a list of HeroStats objects to a JSON file.
     *
     * @param heroStats the list of HeroStats to write.
     * @throws IOException if an error occurs during file writing.
     */
    public void writeJsonToFile(final List<HeroStats> heroStats) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(RESPONSE_FILE);
             JsonWriter writer = new JsonWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8))) {
            writer.beginArray();
            for (int i = 0; i < Math.min(heroStats.size(), 1000); i++) {
                GSON.toJson(heroStats.get(i), HeroStats.class, writer);
            }
            writer.endArray();
        }
    }

    /**
     * Writes an array of long values to a JSON file.
     *
     * @param resultInts the array of long values to write.
     * @param size the number of elements to write.
     * @throws IOException if an error occurs during file writing.
     */
    public void writeMiniOptimizationResponsesToFile(final long[] resultInts, final long size) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(RESPONSE_FILE);
             JsonWriter writer = new JsonWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8))) {
            writer.beginArray();
            for (int i = 0; i < size; i++) {
                writer.value(resultInts[i]);
            }
            writer.endArray();
        }
    }

    /**
     * Converts an array of long values to a JSON string.
     *
     * @param itemIds the array of long values to convert.
     * @param size the number of elements to include in the string.
     * @return the JSON representation of the array as a string.
     * @throws IOException if an error occurs during conversion.
     */
    public String writeString(final long[] itemIds, final long size) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             JsonWriter writer = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8))) {
            writer.beginArray();
            for (int i = 0; i < size * 6; i++) {
                writer.value(itemIds[i]);
            }
            writer.endArray();
            return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
        }
    }
}
