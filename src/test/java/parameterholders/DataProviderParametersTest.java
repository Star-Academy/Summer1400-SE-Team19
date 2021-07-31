package parameterholders;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parameterholders.abstraction.DataProviderParametersInterface;

import java.io.File;

public class DataProviderParametersTest {

    private static final DataProviderParametersInterface
            dataProviderParametersInterface = new DataProviderParameters();
    @Mock
    private static DataContainer dataContainer;
    @Mock
    private static File fileDirectory;

    @BeforeAll
    public static void init() {
        dataProviderParametersInterface.setDataContainer(dataContainer);
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
