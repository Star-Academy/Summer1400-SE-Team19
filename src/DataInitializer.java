import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class DataInitializer {
    private static DataInitializer instance = new DataInitializer();
    private DataContainer dataContainer = DataContainer.getInstance();
    private final File fileDirectory = new File("resources/SampleEnglishData");

    private DataInitializer() {}

    public static DataInitializer getInstance() {
        return instance;
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
            dataContainer.addAddress(word, fileName);
        }
    }


}
