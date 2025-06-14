public class wordCounter {
    private int count = 0;
    private String[] words;
    private String target;

    public wordCounter(String[] words, String target) {
        this.words = words;
        this.target = target;
    }

    public void getNoOfOccurences() {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
};
