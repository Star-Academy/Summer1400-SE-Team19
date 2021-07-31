package database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.DataProviderParametersInterface;

import java.io.File;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataProviderTest {


    @Mock
    private DataProviderParametersInterface parameters;
    @Mock
    private File fileDirectory;
    @Mock
    private DataContainer dataContainer;
    @Mock
    private File file;

    @Test
    public void initializeTest() {
        when(fileDirectory.listFiles()).thenReturn(new File[]{file});

    }
}
