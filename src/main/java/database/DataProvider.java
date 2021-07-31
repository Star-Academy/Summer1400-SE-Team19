package database;

import parameterholders.DataProviderParametersInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class DataProvider {
    private final DataContainer dataContainer;
    private final File fileDirectory;
    private final FileReader reader;

    public DataProvider(DataProviderParametersInterface dataProviderParametersInterface) {
        dataContainer = dataProviderParametersInterface.getDataContainer();
        fileDirectory = dataProviderParametersInterface.getFileDirectory();
        reader = dataProviderParametersInterface.getReader();
    }

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public void initialize() {
        for (File file : Objects.requireNonNull(fileDirectory.listFiles())) {
            try {
                reader.setFile(file);
                reader.read();
            } catch (FileNotFoundException ignored) {
            }
        }
    }


}
