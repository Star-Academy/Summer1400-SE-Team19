package database;

import parameterholders.DataProviderParameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class DataProvider {
    private final DataContainer dataContainer;
    private final File fileDirectory;

    public DataProvider(DataProviderParameters dataProviderParameters) {
        dataContainer = dataProviderParameters.getDataContainer();
        fileDirectory = dataProviderParameters.getFileDirectory();
    }

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public void initialize() {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            try {
                processInfo(file);
            } catch (FileNotFoundException ignored) {

            }
        }
    }

    private void processInfo(File file) throws FileNotFoundException {
        int fileName = Integer.parseInt(file.getName());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            addWordToDataContainer(fileName, scanner);
        }
    }

    private void addWordToDataContainer(int fileName, Scanner scanner) {
        String word = scanner.next().toLowerCase();
        word = word.replaceAll("[^a-zA-Z0-9]", "");
        dataContainer.addFileName(word, fileName);
    }


}
