package com.OracleHealth;

import java.time.Duration;
import java.time.Instant;

public class InterruptedSleepingRunner implements Runnable {
    @Override
    public void run() {
        doAPseudoHeavyWeightJob();
    }

    private void doAPseudoHeavyWeightJob() {
        for (int i = 0; i < 100; i++) {
            // You are kidding me
            System.out.println(i + " " + i * 2);
            // Let me sleep <evil grin>
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted\n Exiting...");
                break;
            } else {
                sleepBabySleep();
            }
        }
    }

    protected void sleepBabySleep() {
        try {

            Instant one = Instant.ofEpochSecond(1845836);
            long waitTime = Duration.between(Instant.now(), one).toMillis();
//            int limit = 60;//60 requests total
//            int remaining = 30;//remaining requests left until the next Reset
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
//            long waitTime = Duration.between(Instant.now(), resetTime).toMillis();
        }
    }
}
