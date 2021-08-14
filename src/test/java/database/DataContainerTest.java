package database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.DataContainerParametersHolder;

import java.util.HashMap;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataContainerTest {

    @Mock
    private DataContainerParametersHolder dataContainerParametersHolder;

    private DataContainer dataContainer;
    HashSet<Integer> hashSet;
    private HashMap<String, HashSet<Integer>> allData;

    @BeforeEach
    public void init() {
        hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        allData = new HashMap<>();
        allData.put("test", hashSet);
        when(dataContainerParametersHolder.getAllData()).thenReturn(allData);
        dataContainer = new DataContainer(dataContainerParametersHolder);
    }

    @Test
    public void getFilesNameWithSearchedWordTest() {
        Assertions.assertNull(dataContainer.getFilesNameWithSearchedWord("empty"));
        Assertions.assertEquals(2, dataContainer.getFilesNameWithSearchedWord("test").size());
    }

    @Test
    public void getAllDataTest() {
        Assertions.assertEquals(allData, dataContainer.getAllData());
    }

    @Test
    public void getWordAddressesTest() {
        Assertions.assertEquals(hashSet, dataContainer.getFilesNameWithSearchedWord("test"));
    }
}
