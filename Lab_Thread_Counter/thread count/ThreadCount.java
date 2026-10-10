
import java.util.concurrent.atomic.AtomicLong;

public class ThreadCount extends Thread {

    // Shared thread-safe static counter
    static AtomicLong safeStaticCounter = new AtomicLong(0);

    // Shared unsafe static counter
    static long unsafeStaticCounter = 0;

    // Each thread object has its own instance counter
    long instanceCounter = 0;

    long increments;
    boolean safeMode;

    // Constructor
    public ThreadCount(long increments, boolean safeMode) {
        this.increments = increments;
        this.safeMode = safeMode;
    }

    // Thread execution
    @Override
    public void run() {
        for (long i = 0; i < increments; i++) {

            // Thread-safe or unsafe static increment
            if (safeMode) {
                safeStaticCounter.incrementAndGet();
            } else {
                unsafeStaticCounter++;
            }

            // Each object updates its own counter
            instanceCounter++;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        if (args.length != 3) {
            System.out.println(
                "Usage: java ThreadCount <threads> <increments> <true/false>"
            );
            return;
        }

        int numberOfThreads = Integer.parseInt(args[0]);
        long increments = Long.parseLong(args[1]);
        boolean safeMode = Boolean.parseBoolean(args[2]);

        if (numberOfThreads < 1 || increments < 0
                || !(args[2].equalsIgnoreCase("true")
                || args[2].equalsIgnoreCase("false"))) {
            System.out.println("Invalid input.");
            return;
        }

        // Reset counters before each experiment
        safeStaticCounter.set(0);
        unsafeStaticCounter = 0;

        ThreadCount[] threads =
                new ThreadCount[numberOfThreads];

        long nonStaticTotal = 0;

        // Create and start all threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] =
                    new ThreadCount(increments, safeMode);
            threads[i].start();
        }

        // Wait for every thread to finish
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        // Add all individual instance counters
        for (int i = 0; i < numberOfThreads; i++) {
            nonStaticTotal += threads[i].instanceCounter;
        }

        long staticTotal;

        if (safeMode) {
            staticTotal = safeStaticCounter.get();
        } else {
            staticTotal = unsafeStaticCounter;
        }

        long expectedCount =
                (long) numberOfThreads * increments;

        long difference =
                Math.abs(staticTotal - nonStaticTotal);

        double percentageDifference;

        if (nonStaticTotal == 0) {
            percentageDifference =
                    (staticTotal == 0) ? 0.0 : Double.NaN;
        } else {
            percentageDifference =
                    (double) difference / nonStaticTotal * 100.0;
        }

        System.out.println("========== THREAD COUNTER LAB ==========");
        System.out.println("Threads: " + numberOfThreads);
        System.out.println("Increments per thread: " + increments);
        System.out.println("Mode: "
                + (safeMode ? "Thread-safe" : "Unsafe"));
        System.out.println("Expected count: " + expectedCount);
        System.out.println("Static count: " + staticTotal);
        System.out.println("Non-static total: " + nonStaticTotal);
        System.out.println("Absolute difference: " + difference);

        if (Double.isNaN(percentageDifference)) {
            System.out.println("Percentage difference: Undefined");
        } else {
            System.out.printf(
                    "Percentage difference: %.4f%%%n",
                    percentageDifference);
        }

        System.out.println("=========================================");
    }
}
