package parameterholders;

import java.util.HashMap;
import java.util.HashSet;

public class DataContainerParameters {
    private HashMap<String, HashSet<Integer>> allData;

    public HashMap<String, HashSet<Integer>> getAllData() {
        return allData;
    }

    public void setAllData(HashMap<String, HashSet<Integer>> allData) {
        this.allData = allData;
    }


}
