import java.util.*;

public class Searcher {
    private final Scanner scanner;
    private final HashMap<String, ArrayList<Integer>> wordHashmap;
    private final Comparator<String> queryComparator = (word1, word2) -> {
        if (word1.startsWith("+"))
            return -1;
        if (word2.startsWith("+"))
            return 1;
        if (word1.startsWith("-"))
            return -1;
        if (word2.startsWith("-"))
            return 1;
        return 0;
    };

    public Searcher(HashmapInitializer hashmapInitializer) {
        scanner = new Scanner(System.in);
        wordHashmap = hashmapInitializer.getWordHashmap();
    }

    public void run() {
        String input;
        while (true) {
            input = scanner.nextLine().toLowerCase();
            input = input.replaceAll("\\+", " +");
            input = input.replaceAll("-", " -");
            String[] words = input.split("[ ]+");
            // Making "words" an arraylist to sort it
            sortWordsQuery(words);

            ArrayList<Integer> arrayList = wordHashmap.get(words[0]);
            if (arrayList == null)
                arrayList = new ArrayList<>();
            applyingSearchOperation(words, arrayList);
            System.out.println(arrayList);
        }
    }

    private void applyingSearchOperation(String[] words, ArrayList<Integer> arrayList) {
        for (int i = 1; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if (word.charAt(0) == '+')
                arrayList.addAll(wordHashmap.get(word.deleteCharAt(0).toString()));
            else if (word.charAt(0) == '-')
                arrayList.removeAll(wordHashmap.get(word.deleteCharAt(0).toString()));
            else
                arrayList.retainAll(wordHashmap.get(words[i]));
        }
    }

    private void sortWordsQuery(String[] words) {
        ArrayList<String> wordAsAnArrayList = new ArrayList<>(Arrays.asList(words));
        wordAsAnArrayList.sort(this.queryComparator);
        for (int i = 0; i < words.length; i++) {
            words[i] = wordAsAnArrayList.get(i);
        }
    }
}
