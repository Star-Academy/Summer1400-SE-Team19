package parameterholders.abstraction;

import java.util.HashMap;
import java.util.HashSet;

public interface DataContainerParametersInterface {
    HashMap<String, HashSet<Integer>> getAllData();

    void setAllData(HashMap<String, HashSet<Integer>> allData);
}
