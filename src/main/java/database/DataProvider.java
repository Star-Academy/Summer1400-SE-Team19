package database;

import parameterholders.abstraction.DataProviderParametersInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class DataProvider {
    private final File fileDirectory;
    private final FileReader reader;

    public DataProvider(DataProviderParametersInterface dataProviderParameters) {
        fileDirectory = dataProviderParameters.getFileDirectory();
        reader = dataProviderParameters.getReader();
    }

    public void initialize() {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            try {
                callFileReader(initializeCustomScanner(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private CustomScanner initializeCustomScanner(File file) throws FileNotFoundException {
        CustomScanner customScanner = new CustomScanner();
        customScanner.setFile(file);
        customScanner.setScanner(new Scanner(file));
        return customScanner;
    }

    private void callFileReader(CustomScanner customScanner) throws FileNotFoundException {
        reader.setCustomScanner(customScanner);
        reader.read();
    }



}
