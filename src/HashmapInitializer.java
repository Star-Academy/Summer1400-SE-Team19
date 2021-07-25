import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class HashmapInitializer {
    private final HashMap<String, ArrayList<Integer>> wordHashmap = new HashMap<>();
    private final File fileDirectory = new File("resources/SampleEnglishData");

    public HashMap<String, ArrayList<Integer>> getWordHashmap() {
        return wordHashmap;
    }

    public void initialize() throws Exception {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            processInfo(file);
        }
    }

    private void processInfo(File file) throws Exception {
        int fileName = Integer.parseInt(file.getName());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!wordHashmap.containsKey(word)) {
                wordHashmap.put(word, new ArrayList<>());
            }
            try {
                if (wordHashmap.get(word).contains(fileName)) throw new RepeatedElementException();
                wordHashmap.get(word).add(fileName);
            } catch (RepeatedElementException ignored) {
            }
        }
    }


}
