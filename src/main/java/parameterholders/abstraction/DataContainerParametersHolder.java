package parameterholders.abstraction;

import java.util.HashMap;
import java.util.HashSet;

public interface DataContainerParametersHolder {
    HashMap<String, HashSet<Integer>> getAllData();

    void setAllData(HashMap<String, HashSet<Integer>> allData);
}
