package parameterholders;

import database.DataContainer;

import java.io.File;

public class DataProviderParameters implements DataProviderParametersInterface {
    private DataContainer dataContainer;
    private File fileDirectory;

    @Override
    public DataContainer getDataContainer() {
        return dataContainer;
    }

    @Override
    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Override
    public File getFileDirectory() {
        return fileDirectory;
    }

    @Override
    public void setFileDirectory(File fileDirectory) {
        this.fileDirectory = fileDirectory;
    }
}
