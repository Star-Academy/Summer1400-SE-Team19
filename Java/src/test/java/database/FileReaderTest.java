package database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.DataContainerParameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {
    @Mock
    private DataContainer dataContainer;
    @Mock
    private CustomScanner customScanner;

    @BeforeEach
    public void init() {

    }

    @Test
    public void addAddressForExistingWordTest() {
        FileReader fileReader = new FileReader(dataContainer);
        fileReader.setCustomScanner(customScanner);
        when(customScanner.hasNext()).thenReturn(true).thenReturn(false);
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 3));
        HashMap<String, HashSet<Integer>> demoAllData = new HashMap<>();
        demoAllData.put("test", demoResult);
        when(customScanner.getFileName()).thenReturn("7");
        when(dataContainer.getAllData()).thenReturn(demoAllData);
        when(customScanner.getNext()).thenReturn("test");
        try {
            fileReader.read();
        } catch (FileNotFoundException ignored) {
        }
        verify(dataContainer, times(1)).getWordAddresses(any());
    }

    @Test
    public void addAddressForNonExistingWordTest() {

    }
}
