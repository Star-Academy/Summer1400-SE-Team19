import words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Searcher {
    private static final Searcher INSTANCE = new Searcher();
    private final Comparator<String> queryComparator;
    private final DataContainer dataContainer;

    {
        queryComparator = initializeComparator();
        dataContainer = DataContainer.getInstance();
    }

    private Searcher() {
    }

    public static Searcher getINSTANCE() {
        return INSTANCE;
    }

    private Comparator<String> initializeComparator() {
        return this::compareWords;
    }

    private int compareWords(String word1, String word2) {
        if (word1.startsWith("+"))
            return -1;
        if (word2.startsWith("+"))
            return 1;
        if (word1.startsWith("-"))
            return -1;
        if (word2.startsWith("-"))
            return 1;
        return 0;
    }

    public void run() {
        String input;
        while (true) {
            input = getInput();
            input = processInput(input);
            String[] words = input.split("[ ]+");
            ArrayList<Integer> results = dataContainer.getAddress(words[words.length - 1]);

            ArrayList<String> wordsInOrder = sortWordsQuery(words);

            TypeChecker typeChecker = new TypeChecker(wordsInOrder);
            ArrayList<Word> separateWords = typeChecker.getWords();

            for (Word separateWord : separateWords) {
                separateWord.action(dataContainer.getAddress(separateWord.getWordInString()), results);
            }

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

    private ArrayList<String> sortWordsQuery(String[] words) {
        // Making "words" an arraylist to sort it
        ArrayList<String> wordAsAnArrayList = new ArrayList<>(Arrays.asList(words));
        wordAsAnArrayList.sort(this.queryComparator);
        return wordAsAnArrayList;
    }
}
