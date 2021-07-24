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
            input = scanner.nextLine().toLowerCase();
            String[] words = input.split("[ ]+");
            ArrayList<Integer> arrayList = wordHashmap.get(words[0]);
            for (int i = 1; i < words.length; i++) {
                ArrayList<Integer> otherArrayList = wordHashmap.get(words[i]);
                arrayList.retainAll(otherArrayList);
            }
            System.out.println(arrayList);
        }
    }
}
