package parameterholders;

import database.DataContainer;

import java.io.File;

public interface DataProviderParametersInterface {
    DataContainer getDataContainer();

    void setDataContainer(DataContainer dataContainer);

    File getFileDirectory();

    void setFileDirectory(File fileDirectory);
}
