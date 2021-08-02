package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class DataContainerParametersTest {

    private final DataContainerParameters dataContainerParameters = new DataContainerParameters();

    @Mock
    private HashMap<String, HashSet<Integer>> allData;


    @Test
    public void setAllDataTest() {
        dataContainerParameters.setAllData(allData);
        // Just expecting to not crash
    }

    @Test
    public void getAllDataTest() {
        dataContainerParameters.setAllData(allData);
        Assertions.assertNotNull(dataContainerParameters.getAllData());
        Assertions.assertEquals(dataContainerParameters.getAllData(), allData);
    }
}
