package com.OracleHealth.stream_apis;

import java.util.stream.LongStream;

public class ParallelReductionExample {
    public static void main(String[] args) {
        long start, end;
        long n = 1000000000L; // 1 billion

        // Sequential Processing
        start = System.currentTimeMillis();
        long sequentialResult = LongStream.rangeClosed(1, n)
                .map(x -> x * x)
                .reduce(0, (x, y) -> x + y);
        end = System.currentTimeMillis();
        System.out.println("Sequential Result: " + sequentialResult);
        System.out.println("Sequential Execution Time: " + (end - start) + " ms");

        // Parallel Processing
        start = System.currentTimeMillis();
        long parallelResult = LongStream.rangeClosed(1, n)
                .parallel()
                .map(y -> y * y)
                .reduce(0, (x, y) -> x + y);
        end = System.currentTimeMillis();
        System.out.println("Parallel Result: " + parallelResult);
        System.out.println("Parallel Execution Time: " + (end - start) + " ms");
    }
}
