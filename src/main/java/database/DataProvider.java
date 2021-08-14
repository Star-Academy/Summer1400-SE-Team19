package database;

import parameterholders.abstraction.DataProviderParametersHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class DataProvider {
    private final DataContainer dataContainer;
    private final File fileDirectory;
    private final FileReader reader;

    public DataProvider(DataProviderParametersHolder dataProviderParametersHolder) {
        dataContainer = dataProviderParametersHolder.getDataContainer();
        fileDirectory = dataProviderParametersHolder.getFileDirectory();
        reader = dataProviderParametersHolder.getReader();
    }

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public void initialize() {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            processFileAndScanner(file);
        }
    }

    private void processFileAndScanner(File file) {
        try {
            readFile(initializeCustomScanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private CustomScanner initializeCustomScanner(File file) throws FileNotFoundException {
        CustomScanner customScanner = new CustomScanner();
        customScanner.setFile(file);
        customScanner.setScanner(new Scanner(file));
        return customScanner;
    }

    private void readFile(CustomScanner customScanner) throws FileNotFoundException {
        reader.setCustomScanner(customScanner);
        reader.read();
    }


}
