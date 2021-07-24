import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Searcher {
    private final Scanner scanner;
    private final HashMap<String, ArrayList<Integer>> wordHashmap;

    public Searcher(HashmapInitializer hashmapInitializer) {
        scanner = new Scanner(System.in);
        wordHashmap = hashmapInitializer.getWordHashmap();
    }

    public void run() {
        String input;
        while (true) {
            input = scanner.nextLine();
            System.out.println(wordHashmap.get(input));
        }
    }
}
