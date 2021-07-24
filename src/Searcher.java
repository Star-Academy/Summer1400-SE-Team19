import java.util.ArrayList;
import java.util.Arrays;
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
            input = input.replaceAll("\\+", " +");
            input = input.replaceAll("-", " -");
            String[] words = input.split("[ ]+");
            ArrayList<Integer> arrayList = wordHashmap.get(words[0]);
            for (int i = 1; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                if (word.charAt(0) == '+')
                    arrayList.addAll(wordHashmap.get(word.deleteCharAt(0).toString()));
                else if (word.charAt(0) == '-')
                    arrayList.removeAll(wordHashmap.get(word.deleteCharAt(0).toString()));
                else
                    arrayList.retainAll(wordHashmap.get(words[i]));
            }
            System.out.println(arrayList);
        }
    }
}
