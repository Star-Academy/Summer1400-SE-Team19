package database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {
    @Mock
    private DataContainer dataContainer;
    @Mock
    private CustomScanner customScanner;

    @Test
    public void addAddressForExistingWordTest() {
        FileReader fileReader = new FileReader(dataContainer);
        fileReader.setCustomScanner(customScanner);
        setMockingActionsForExistingWord();
        try {
            fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        verify(dataContainer, times(1)).getFilesNameWithSearchedWord(any());
    }

    private void setMockingActionsForExistingWord() {
        when(customScanner.hasNext()).thenReturn(true).thenReturn(false);
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 3));
        HashMap<String, HashSet<Integer>> demoAllData = new HashMap<>();
        demoAllData.put("test", demoResult);
        when(customScanner.getFileName()).thenReturn("7");
        when(dataContainer.getAllData()).thenReturn(demoAllData);
        when(customScanner.getNext()).thenReturn("test");
    }

    @Test
    public void addAddressForNonExistingWordTest() {
        FileReader fileReader = new FileReader(dataContainer);
        fileReader.setCustomScanner(customScanner);
        HashMap<String, HashSet<Integer>> demoAllData = new HashMap<>();
        setMockingActionsForNonExistingWord(demoAllData);
        try {
            fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        verify(dataContainer, times(1)).getFilesNameWithSearchedWord(any());
        Assertions.assertEquals(0, demoAllData.get("test").size());
    }

    private void setMockingActionsForNonExistingWord(HashMap<String, HashSet<Integer>> demoAllData) {
        when(customScanner.hasNext()).thenReturn(true).thenReturn(false);
        when(customScanner.getFileName()).thenReturn("7");
        when(dataContainer.getAllData()).thenReturn(demoAllData);
        when(customScanner.getNext()).thenReturn("test");
    }
}
