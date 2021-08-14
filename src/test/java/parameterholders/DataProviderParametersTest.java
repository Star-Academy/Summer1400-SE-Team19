package parameterholders;

import database.DataContainer;
import database.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parameterholders.abstraction.DataProviderParametersHolder;

import java.io.File;

public class DataProviderParametersTest {

    private final DataProviderParametersHolder
            dataProviderParametersHolder = new DataProviderParameters();
    @Mock
    private DataContainer dataContainer;
    @Mock
    private File fileDirectory;
    @Mock
    private FileReader reader;


    @Test
    public void getDataContainerTest() {
        dataProviderParametersHolder.setDataContainer(dataContainer);
        Assertions.assertNull(dataProviderParametersHolder.getDataContainer());
        Assertions.assertEquals(dataContainer, dataProviderParametersHolder.getDataContainer());
    }

    @Test
    public void getFileDirectoryTest() {
        dataProviderParametersHolder.setFileDirectory(fileDirectory);
        Assertions.assertNull(dataProviderParametersHolder.getFileDirectory());
        Assertions.assertEquals(fileDirectory, dataProviderParametersHolder.getFileDirectory());
    }

    @Test
    public void getFileReaderTest() {
        dataProviderParametersHolder.setReader(reader);
        Assertions.assertNull(dataProviderParametersHolder.getReader());
        Assertions.assertEquals(reader, dataProviderParametersHolder.getReader());
    }
}
