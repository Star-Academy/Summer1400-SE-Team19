import modifiers.Searcher;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;
import parameterholders.UserInterfaceParameters;
import words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final TypeChecker typeChecker;
    private final Searcher searcher;
    private final FilterInterface filter;
    private final Scanner scanner;
    private final HashSet<Integer> result;

    public UserInterface(UserInterfaceParameters userInterfaceParametersInterface) {
        searcher = userInterfaceParametersInterface.getSearcher();
        typeChecker = userInterfaceParametersInterface.getTypeChecker();
        filter = userInterfaceParametersInterface.getFilter();
        result = userInterfaceParametersInterface.getResult();
        scanner = userInterfaceParametersInterface.getScanner();
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
        return mergeSearchResult(wordsInObject);
    }

    private HashSet<Integer> mergeSearchResult(ArrayList<Word> words) {
        for (Word word : words) {
            filter.filter(word, result);
        }
        return result;
    }


}
