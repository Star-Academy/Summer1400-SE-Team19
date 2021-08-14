import modifiers.Searcher;
import modifiers.TypeChecker;
import parameterholders.abstraction.UserInterfaceParametersHolder;
import modifiers.abstraction.Filter;
import words.Word;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final String end = "#end";
    private final TypeChecker typeChecker;
    private final Searcher searcher;
    private final Scanner scanner;
    private final Filter filter;
    private final HashSet<Integer> result;

    public UserInterface(UserInterfaceParametersHolder userInterfaceParametersHolder) {
        searcher = userInterfaceParametersHolder.getSearcher();
        typeChecker = userInterfaceParametersHolder.getTypeChecker();
        scanner = userInterfaceParametersHolder.getScanner();
        filter = userInterfaceParametersHolder.getFilter();
        result = userInterfaceParametersHolder.getResult();
    }

    public void run() {
        String input;
        while (true) {
            input = getInput();
            if (input.equals(end)) break;
            processInput(input);
        }
    }

    private void processInput(String input) {
        String[] words = input.split("\s+");
        HashSet<Integer> results = getResult(words);
        System.out.println(results);
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
