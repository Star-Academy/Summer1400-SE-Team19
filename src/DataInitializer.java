import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class DataInitializer {
    private static final DataInitializer INSTANCE;

    static {
        INSTANCE = new DataInitializer();
    }

    private final DataContainer dataContainer = DataContainer.getInstance();
    private final File fileDirectory = new File("resources/SampleEnglishData");

    private DataInitializer() {
    }

    public static DataInitializer getInstance() {
        return INSTANCE;
    }

    public void initialize() {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            try {
                processInfo(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
