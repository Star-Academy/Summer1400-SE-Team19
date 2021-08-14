package parameterholders;

import database.DataContainer;
import database.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parameterholders.abstraction.DataProviderParametersInterface;

import java.io.File;

public class DataProviderParametersTest {

    private final DataProviderParametersInterface
            dataProviderParametersInterface = new DataProviderParameters();
    @Mock
    private DataContainer dataContainer;
    @Mock
    private File fileDirectory;
    @Mock
    private FileReader reader;


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

    @Test
    public void getFileReaderTest() {
        dataProviderParametersInterface.setReader(reader);
        Assertions.assertNull(dataProviderParametersInterface.getReader());
        Assertions.assertEquals(reader, dataProviderParametersInterface.getReader());
    }
}
