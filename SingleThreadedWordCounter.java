import java.util.Scanner;

public class SingleThreadedWordCounter {
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
        wordCounter wordCounter1 = new wordCounter(words, firstTarget);
        wordCounter1.getNoOfOccurences();
        int firstTargetWordCount = wordCounter1.getCount();

        wordCounter wordCounter2 = new wordCounter(words, secondTarget);
        wordCounter2.getNoOfOccurences();
        int secondTargetWordCount = wordCounter2.getCount();

        long endingTime = System.currentTimeMillis();
        long timeTaken = endingTime - startingTime;

        System.out.printf("Number of threads: 1\n");
        System.out.printf("%s: %d\n", firstTarget, firstTargetWordCount);
        System.out.printf("%s: %d\n", secondTarget, secondTargetWordCount);
        System.out.printf("Time taken: %dms\n", timeTaken);
    }
};