import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Searcher {
    private final Comparator<String> queryComparator;
    private final DataContainer dataContainer;

    {
        queryComparator = initializeComparator();
        dataContainer = DataContainer.getInstance();
    }

    private Comparator<String> initializeComparator() {
        return (word1, word2) -> {
            if (doesHavePriority(word2))
                return 1;
            if (doesHavePriority(word1))
                return -1;

            return 0;
        };
    }

    private boolean doesHavePriority(String word2) {
        return word2.startsWith("+") || word2.startsWith("-");
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
            checkType(words[i], arrayList);
        }
        return arrayList;
    }

    private void checkType(String word1, ArrayList<Integer> arrayList) {
        StringBuilder word = new StringBuilder(word1);
        if (word.charAt(0) == '+')
            arrayList.addAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
        else if (word.charAt(0) == '-')
            arrayList.removeAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
        else
            arrayList.retainAll(dataContainer.getAddress(word.toString()));
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
