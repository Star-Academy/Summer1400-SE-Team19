import modifiers.Filter;
import modifiers.Searcher;
import modifiers.TypeChecker;
import parameterholders.abstraction.UserInterfaceParametersInterface;
import words.Word;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private final TypeChecker typeChecker;
    private final Searcher searcher;
    private final Scanner scanner;
    private final Filter filter;
    private final HashSet<Integer> result;

    public UserInterface(UserInterfaceParametersInterface userInterfaceParametersInterface, Searcher searcher) {
        this.searcher = searcher;
        typeChecker = userInterfaceParametersInterface.getTypeChecker();
        scanner = userInterfaceParametersInterface.getScanner();
        filter = userInterfaceParametersInterface.getFilter();
        result = userInterfaceParametersInterface.getResult();
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
