package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.HashSet;

public class DataContainerParametersTest {

    private DataContainerParameters dataContainerParameters = new DataContainerParameters();

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
