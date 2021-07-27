package view;

import controller.modifiers.Merger;
import controller.modifiers.Searcher;
import controller.modifiers.TypeChecker;
import model.parameterholders.UserInterfaceParameters;
import model.words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final TypeChecker typeChecker;
    private final Searcher searcher;
    private final Merger merger;
    private final Scanner scanner;

    public UserInterface(UserInterfaceParameters userInterfaceParameters, Searcher searcher) {
        this.searcher = searcher;
        typeChecker = userInterfaceParameters.getTypeChecker();
        merger = userInterfaceParameters.getMerger();
        scanner = userInterfaceParameters.getScanner();
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
