import words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Searcher {
    private final DataContainer dataContainer;

    public Searcher(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }


    public void run() {
        String input;
        while (true) {
            input = getInput();
            if (input.equals("#end")) {
                break;
            }

            String[] words = input.split("\s+");
            ArrayList<Integer> results = dataContainer.getFileNames(words[0]);

            ArrayList<Word> separateWords = getWords(words);

            sortWords(separateWords);
            mergeSearchResults(results, separateWords);

            System.out.println(results);
        }
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    private void mergeSearchResults(ArrayList<Integer> results, ArrayList<Word> separateWords) {
        for (Word separateWord : separateWords) {
            separateWord.filter(dataContainer.getFileNames(separateWord.getWordInString()), results);
        }
    }


    private ArrayList<Word> getWords(String[] words) {
        ArrayList<String> wordsAsArrayList = new ArrayList<>(Arrays.asList(words));

        TypeChecker typeChecker = new TypeChecker(wordsAsArrayList);
        return typeChecker.getWords();
    }


    private void sortWords(ArrayList<Word> separateWords) {
        Comparator<Word> comparator = Comparator.comparing(Word::getPriority);
        separateWords.sort(comparator);
    }

}
