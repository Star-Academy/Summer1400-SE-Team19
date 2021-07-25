import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Searcher {
    private static Searcher INSTANCE = new Searcher();
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
    private final DataContainer dataContainer = DataContainer.getInstance();

    private Searcher() {}

    public static Searcher getInstance() {
        return INSTANCE;
    }

    public void run() {
        String input;
        while (true) {
            input = getInput();
            input = processInput(input);
            String[] words = input.split("[ ]+");
            sortWordsQuery(words);
            ArrayList<Integer> results = applyingSearchOperation(words);
            System.out.println(results);
        }
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    private String processInput(String input) {
        input = input.replaceAll("\\+", " +");
        input = input.replaceAll("-", " -");
        return input;
    }

    private ArrayList<Integer> applyingSearchOperation(String[] words) {
        ArrayList<Integer> arrayList = dataContainer.getAddress(words[0]);
        for (int i = 1; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if (word.charAt(0) == '+')
                arrayList.addAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
            else if (word.charAt(0) == '-')
                arrayList.removeAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
            else
                arrayList.retainAll(dataContainer.getAddress(words[i]));
        }
        return arrayList;
    }

    private void sortWordsQuery(String[] words) {
        // Making "words" an arraylist to sort it
        ArrayList<String> wordAsAnArrayList = new ArrayList<>(Arrays.asList(words));
        wordAsAnArrayList.sort(this.queryComparator);
        for (int i = 0; i < words.length; i++) {
            words[i] = wordAsAnArrayList.get(i);
        }
    }
}
