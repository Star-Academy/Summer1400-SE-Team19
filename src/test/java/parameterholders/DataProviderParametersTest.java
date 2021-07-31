package parameterholders;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DataProviderParametersTest {

    private DataProviderParameters dataProviderParameters = new DataProviderParameters();
    private DataContainer dataContainer;
    private File fileDirectory;

    @Test
    public void setDataContainerTest() {
        dataProviderParameters.setDataContainer(dataContainer);
    }

    @Test
    public void setFileDirectoryTest() {
        dataProviderParameters.setFileDirectory(fileDirectory);
    }

    @Test
    public void getDataContainerTest() {
        dataProviderParameters.setDataContainer(dataContainer);
        Assertions.assertNull(dataProviderParameters.getDataContainer());
        Assertions.assertEquals(dataContainer, dataProviderParameters.getDataContainer());
    }

    @Test
    public void getFileDirectoryTest() {
        dataProviderParameters.setFileDirectory(fileDirectory);
        Assertions.assertNull(dataProviderParameters.getFileDirectory());
        Assertions.assertEquals(fileDirectory, dataProviderParameters.getFileDirectory());
    }
}
