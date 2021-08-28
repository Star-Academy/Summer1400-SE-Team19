import modifiers.DataCollector;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;
import parameterholders.UserInterfaceParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final TypeChecker typeChecker;
    private final DataCollector dataCollector;
    private final FilterInterface positiveWordsFilter;
    private final FilterInterface negativeWordsFilter;
    private final FilterInterface neutralWordsFilter;
    private final Scanner scanner;

    public UserInterface(UserInterfaceParameters userInterfaceParametersInterface) {
        dataCollector = userInterfaceParametersInterface.getSearcher();
        typeChecker = userInterfaceParametersInterface.getTypeChecker();
        positiveWordsFilter = userInterfaceParametersInterface.getPositiveFilter();
        neutralWordsFilter = userInterfaceParametersInterface.getPositiveFilter();
        negativeWordsFilter = userInterfaceParametersInterface.getPositiveFilter();
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
        typeChecker.separateWords(wordsAsArrayList);
        var positiveWordsSearchResult = dataCollector.collectData(typeChecker.getPositiveWords());
        var neutralWordsSearchResult = dataCollector.collectData(typeChecker.getNeutralWords());
        var negativeWordsSearchResult = dataCollector.collectData(typeChecker.getNegativeWords());
        return mergeSearchResult(positiveWordsSearchResult,
                neutralWordsSearchResult,
                negativeWordsSearchResult);
    }

    private HashSet<Integer> mergeSearchResult(ArrayList<HashSet<Integer>> positiveWordsSearchResult,
                                               ArrayList<HashSet<Integer>> neutralWordsSearchResult,
                                               ArrayList<HashSet<Integer>> negativeWordsSearchResult) {
        var result = new HashSet<Integer>();
        for (HashSet<Integer> searchResult : positiveWordsSearchResult) {
            positiveWordsFilter.filter(searchResult, result);
        }
        for (HashSet<Integer> searchResult : neutralWordsSearchResult) {
            neutralWordsFilter.filter(searchResult, result);
        }
        for (HashSet<Integer> searchResult : negativeWordsSearchResult) {
            negativeWordsFilter.filter(searchResult, result);
        }
        return result;
    }


}
