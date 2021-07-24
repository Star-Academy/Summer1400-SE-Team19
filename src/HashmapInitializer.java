import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashmapInitializer {
    private HashMap<String, ArrayList<Integer>> wordHashmap = new HashMap<>();
    private final File fileDirectory = new File("resources/SampleEnglishData");

    public HashMap<String, ArrayList<Integer>> getWordHashmap() {
        return wordHashmap;
    }

    public void initialize() throws Exception {
        for (File file : fileDirectory.listFiles()) {
            processInfo(file);
        }
    }

    private void processInfo(File file) throws Exception {
        int fileName = Integer.parseInt(file.getName());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!wordHashmap.containsKey(word)) {
                wordHashmap.put(word, new ArrayList<>());
            }
            wordHashmap.get(word).add(fileName);
        }
    }
}
