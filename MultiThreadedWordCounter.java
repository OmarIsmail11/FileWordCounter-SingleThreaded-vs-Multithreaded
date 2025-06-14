import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class MultiThreadedWordCounter {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        String text = fileProcessor.readFile("file2.txt");
        String[] words = fileProcessor.convertToArrayOfWords(text);
        if (text.isEmpty()) return;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the words to count separated by space: ");
        String input = scanner.nextLine();
        String[] targets = input.split("\\s+");

        String firstTarget = targets[0];
        String secondTarget = targets[1];

        long startingTime = System.currentTimeMillis();
        int numThreads = 10;
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        int chunkSize = words.length / numThreads;

        ArrayList<wordCounterRunnable> counters1 = new ArrayList<>();
        ArrayList<wordCounterRunnable> counters2 = new ArrayList<>();



        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end;
            if (i == numThreads - 1) end = words.length;
            else end = start + chunkSize;

            wordCounterRunnable counter1 = new wordCounterRunnable(words, firstTarget, start, end);
            wordCounterRunnable counter2 = new wordCounterRunnable(words, secondTarget, start, end);

            pool.execute(counter1);
            pool.execute(counter2);

            counters1.add(counter1);
            counters2.add(counter2);
        }

        pool.shutdown();

        try {
            pool.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalCount1 = 0;
        for (wordCounterRunnable counter : counters1) {
            totalCount1 += counter.getCount();
        }

        int totalCount2 = 0;
        for (wordCounterRunnable counter : counters2) {
            totalCount2 += counter.getCount();
        }

        long endingTime = System.currentTimeMillis();
        long timeTaken = endingTime - startingTime;

        System.out.printf("Number of threads: %d\n", numThreads);
        System.out.printf("%s: %d\n", firstTarget, totalCount1);
        System.out.printf("%s: %d\n", secondTarget, totalCount2);
        System.out.printf("Time taken: %dms\n", timeTaken);
    }
}
