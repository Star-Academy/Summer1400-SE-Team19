package parameterholders;

import database.DataContainer;
import database.FileReader;
import parameterholders.abstraction.DataProviderParametersInterface;

import java.io.File;

public class DataProviderParameters implements DataProviderParametersInterface {
    private DataContainer dataContainer;
    private File fileDirectory;
    private FileReader reader;

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public File getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(File fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public FileReader getReader() {
        return reader;
    }

    public void setReader(FileReader reader) {
        this.reader = reader;
    }
}
