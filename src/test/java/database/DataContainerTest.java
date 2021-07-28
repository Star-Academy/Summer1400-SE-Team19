package database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.DataContainerParameters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DataContainerTest {
    @Mock
    private HashMap<String, HashSet<Integer>> demoAllData;
    @Mock
    private DataContainerParameters parameters;


    @BeforeEach
    public void init() {
        when(parameters.getAllData()).thenReturn(demoAllData);
    }

    @Test
    public void searchAvailableWordTest() {
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 3));
        when(demoAllData.get("test")).thenReturn(demoResult);
        when(demoAllData.containsKey("test")).thenReturn(true);

        DataContainer dataContainer = new DataContainer(parameters);
        HashSet<Integer> result = dataContainer.getFilesNameWithSearchedWord("test");
        Assertions.assertEquals(demoResult, result);
    }

    @Test
    public void searchUnAvailableWordTest() {
        when(demoAllData.containsKey("test")).thenReturn(false);

        DataContainer dataContainer = new DataContainer(parameters);
        HashSet<Integer> result = dataContainer.getFilesNameWithSearchedWord("test");
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void addFileNameToNewWord() {
        HashSet<Integer> result = new HashSet<>();
        when(demoAllData.containsKey("test")).thenReturn(false);

        doAnswer((invocation -> {
            Object string = invocation.getArgument(0);
            HashSet<Integer> demo = invocation.getArgument(1);
            Assertions.assertEquals(string, "test");
            Assertions.assertEquals(0, demo.size());
            return null;
        })).when(demoAllData).put("test", new HashSet<>());

        DataContainer dataContainer = new DataContainer(parameters);
        when(demoAllData.get(anyString())).thenReturn(result);
        dataContainer.addFileName("test", 123);
        Assertions.assertTrue(result.contains(123));
    }

    @Test
    public void addFileNameToRepeatedWord() {
        HashSet<Integer> result = new HashSet<>();
        when(demoAllData.containsKey("test")).thenReturn(true);
        when(demoAllData.get("test")).thenReturn(result);
        DataContainer dataContainer = new DataContainer(parameters);
        dataContainer.addFileName("test", 123);
        Assertions.assertTrue(result.contains(123));
    }

}
