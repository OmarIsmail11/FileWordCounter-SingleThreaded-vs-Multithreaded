public class wordCounterRunnable implements Runnable {
    private int count = 0;
    private String[] words;
    private String target;
    private int start;
    private int end;

    public wordCounterRunnable(String[] words, String target, int start, int end) {
        this.words = words;
        this.target = target;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (words[i].equals(target)) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }

}
