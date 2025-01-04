package com.fribbels;

import com.aparapi.Kernel;
import com.aparapi.internal.kernel.KernelManager;
import com.fribbels.core.StatCalculator;
import com.fribbels.db.ArtifactStatsDb;
import com.fribbels.db.BaseStatsDb;
import com.fribbels.db.HeroDb;
import com.fribbels.db.ItemDb;
import com.fribbels.handler.HeroesRequestHandler;
import com.fribbels.handler.ItemsRequestHandler;
import com.fribbels.handler.OcrRequestHandler;
import com.fribbels.handler.OptimizationRequestHandler;
import com.fribbels.handler.SystemRequestHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static HttpServer server;
    private static ExecutorService executorService;

    public static final ArtifactStatsDb artifactStatsDb = new ArtifactStatsDb();
    private static final BaseStatsDb baseStatsDb = new BaseStatsDb();
    private static final HeroDb heroDb = new HeroDb(baseStatsDb);
    private static final ItemDb itemDb = new ItemDb(heroDb);

    private static boolean interrupt = false;
    private static int threads = 10;
    private static long bestDeviceId = 0;

    public static void main(final String[] args) {
        try {
            final int threadsToUse = Runtime.getRuntime().availableProcessors() * 2;
            threads = Math.max(threads, threadsToUse);
        } catch (final RuntimeException e) {
            System.err.println("Error setting number of threads, defaulting to 10: " + e);
        }

        System.out.println("START");
        executorService = Executors.newFixedThreadPool(threads);

        try {
            start();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void start() throws Exception {
        try {
            server = HttpServer.create(new InetSocketAddress("localhost", 8130), 0);
        } catch (final BindException e) {
            System.out.println("Port already in use: " + e);
            System.exit(0);
        }

        final HeroesRequestHandler heroesRequestHandler = new HeroesRequestHandler(
                heroDb, baseStatsDb, artifactStatsDb, itemDb, new StatCalculator());

        server.createContext("/system", new SystemRequestHandler());
        server.createContext("/items", new ItemsRequestHandler(itemDb, heroDb, baseStatsDb, heroesRequestHandler));
        server.createContext("/optimization", new OptimizationRequestHandler(baseStatsDb, heroDb, itemDb));
        server.createContext("/heroes", heroesRequestHandler);
        server.createContext("/ocr", new OcrRequestHandler());

        System.out.println("START BACKEND WITH " + threads + " THREADS");

        server.setExecutor(executorService);
        server.start();
    }

    public static void mainGpuDebugger() {
        System.out.println("** GPU DEBUGGER **");
        System.out.println("** Best device: **\n" + KernelManager.instance().bestDevice());

        try {
            final Kernel kernel = new Kernel() {
                @Override
                public void run() {
                    // Kernel logic
                }
            };

            System.out.println("** Target device: **\n" + kernel.getTargetDevice());
            System.out.println("** OpenCl enabled: **" + kernel.isRunningCL());
        } catch (final Exception e) {
            System.out.println("** Error running OpenCl: **\n" + e);
        }
    }

    public static boolean isInterrupt() {
        return interrupt;
    }

    public static void setInterrupt(boolean interrupt) {
        Main.interrupt = interrupt;
    }

    public static int getThreads() {
        return threads;
    }

    public static void setThreads(int threads) {
        Main.threads = threads;
    }

    public static long getBestDeviceId() {
        return bestDeviceId;
    }

    public static void setBestDeviceId(long bestDeviceId) {
        Main.bestDeviceId = bestDeviceId;
    }

}