import java.util.*;

public class Searcher {
    private DataContainer dataContainer = DataContainer.getInstance();
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

    public void run() {
        String input;
        while (true) {
            input = getInput();
            input = processInput(input);
            String[] words = input.split("[ ]+");

            sortWordsQuery(words);

            ArrayList<Integer> arrayList = dataContainer.getAddress(words[0]);
            if (arrayList == null)
                arrayList = new ArrayList<>();
            applyingSearchOperation(words, arrayList);
            System.out.println(arrayList);
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

    private void applyingSearchOperation(String[] words, ArrayList<Integer> arrayList) {
        for (int i = 1; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            if (word.charAt(0) == '+')
                arrayList.addAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
            else if (word.charAt(0) == '-')
                arrayList.removeAll(dataContainer.getAddress(word.deleteCharAt(0).toString()));
            else
                arrayList.retainAll(dataContainer.getAddress(words[i]));
        }
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
