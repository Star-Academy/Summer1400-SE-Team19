package parameterholders.abstraction;

import database.DataContainer;
import database.FileReader;

import java.io.File;

public interface DataProviderParametersHolder {
    DataContainer getDataContainer();

    void setDataContainer(DataContainer dataContainer);

    File getFileDirectory();

    void setFileDirectory(File fileDirectory);

    FileReader getReader();

    void setReader(FileReader reader);
}
