package com.app.tradingsystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class LowLatencyTradingSystem {

    private static final int EVENT_COUNT = 1000000;

    public static void main(String[] args) {
        List<MarketDataEvent> marketDataEvents = generateMarketDataEvents();

        // Run with different garbage collectors
         runSystem("Serial GC", marketDataEvents, "-XX:+UseSerialGC");
        marketDataEvents = generateMarketDataEvents();
         runSystem("Parallel GC", marketDataEvents, "-XX:+UseParallelGC");
        marketDataEvents = generateMarketDataEvents();
         runSystem("G1 GC", marketDataEvents, "-XX:+UseG1GC");
        marketDataEvents = generateMarketDataEvents();
         runSystem("ZGC", marketDataEvents, "-XX:+UseZGC");
    }

    private static List<MarketDataEvent> generateMarketDataEvents() {
        List<MarketDataEvent> events = new ArrayList<>();
        for (int i = 0; i < EVENT_COUNT; i++) {
            events.add(new MarketDataEvent("Symbol-" + i, 100.0 + i));
        }
        return events;
    }

    private static void runSystem(String gcName, List<MarketDataEvent> events, String gcOptions) {
        System.out.println("\nRunning Trading System with " + gcName);
        System.out.println("--------------------------------------");


        System.out.println("Used Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " MB");


        // Apply garbage collector options
        if (gcOptions != null && !gcOptions.isEmpty()) {
            System.setProperty("java.awt.headless", "true");
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
            System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
            System.setProperty("java.vm.options", gcOptions);

        }

        // Run the trading system
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime);

        // Simulate real-time data processing
        processMarketData(events);

        long endTime = System.currentTimeMillis();
        System.out.println("End Time: " + endTime);

        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " ms");

        // Clear memory
        events.clear();
        System.gc();

        System.out.println("Used Memory after cleanup: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " MB");
    }

    private static void processMarketData(List<MarketDataEvent> marketDataEvents) {
        // Simulate real-time processing of market data with minimal latency
        for (MarketDataEvent event : marketDataEvents) {
            // Execute trades, update positions, etc.
        }
    }

    static class MarketDataEvent {
        private String symbol;
        private double price;

        public MarketDataEvent(String symbol, double price) {
            this.symbol = symbol;
            this.price = price;
        }
    }
}
