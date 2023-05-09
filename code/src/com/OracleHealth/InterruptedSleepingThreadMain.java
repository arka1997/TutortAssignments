package com.OracleHealth;

public class InterruptedSleepingThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptedSleepingRunner());
        thread.start();
        // Giving 10 seconds to finish the job.
        Thread.sleep(100000);
        // Let me interrupt
        thread.interrupt();
    }
}
