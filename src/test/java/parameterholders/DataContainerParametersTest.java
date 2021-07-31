package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class DataContainerParametersTest {

    private DataContainerParameters dataContainerParameters = new DataContainerParameters();
    private HashMap<String, HashSet<Integer>> allData = new HashMap<>();


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
