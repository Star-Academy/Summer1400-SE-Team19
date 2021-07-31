package parameterholders;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parameterholders.abstraction.DataProviderParametersInterface;

import java.io.File;

public class DataProviderParametersTest {

    private DataProviderParametersInterface dataProviderParametersInterface = new DataProviderParameters();
    private DataContainer dataContainer;
    private File fileDirectory;

    @Test
    public void setDataContainerTest() {
        dataProviderParametersInterface.setDataContainer(dataContainer);
    }

    @Test
    public void setFileDirectoryTest() {
        dataProviderParametersInterface.setFileDirectory(fileDirectory);
    }

    @Test
    public void getDataContainerTest() {
        dataProviderParametersInterface.setDataContainer(dataContainer);
        Assertions.assertNull(dataProviderParametersInterface.getDataContainer());
        Assertions.assertEquals(dataContainer, dataProviderParametersInterface.getDataContainer());
    }

    @Test
    public void getFileDirectoryTest() {
        dataProviderParametersInterface.setFileDirectory(fileDirectory);
        Assertions.assertNull(dataProviderParametersInterface.getFileDirectory());
        Assertions.assertEquals(fileDirectory, dataProviderParametersInterface.getFileDirectory());
    }
}
