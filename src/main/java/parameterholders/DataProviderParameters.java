package parameterholders;

import database.DataContainer;

import java.io.File;

public class DataProviderParameters {
    private DataContainer dataContainer;
    private File fileDirectory;

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
}
