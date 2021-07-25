import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class HashmapInitializer {
    private DataController dataController = DataController.getInstance();
    private final File fileDirectory = new File("resources/SampleEnglishData");

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
            dataController.addAddress(word, fileName);
        }
    }


}
