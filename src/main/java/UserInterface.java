import database.DataContainer;
import modifiers.Merger;
import modifiers.Searcher;
import modifiers.TypeChecker;
import words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final TypeChecker typeChecker;
    private final Searcher searcher;
    private final Merger merger;
    private final Scanner scanner;

    public UserInterface(DataContainer dataContainer) {
        searcher = new Searcher(dataContainer);
        typeChecker = new TypeChecker();
        merger = new Merger();
        scanner = new Scanner(System.in);
    }

    public void run() {
        String input;
        while (true) {
            input = getInput();
            if (input.equals("#end")) break;
            String[] words = input.split("\s+");
            HashSet<Integer> results = getResult(words);
            System.out.println(results);
        }
    }

    private String getInput() {
        return scanner.nextLine().toLowerCase();
    }


    private HashSet<Integer> getResult(String[] words) {
        ArrayList<String> wordsAsArrayList = new ArrayList<>(Arrays.asList(words));
        ArrayList<Word> wordsInObject = typeChecker.separateWords(wordsAsArrayList);
        searcher.search(wordsInObject);
        return merger.mergeSearchResult(wordsInObject);
    }


}
