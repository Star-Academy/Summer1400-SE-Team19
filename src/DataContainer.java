import java.util.ArrayList;
import java.util.HashMap;

public class DataContainer {
    private final HashMap<String, ArrayList<Integer>> allData;

    public DataContainer() {
        allData = new HashMap<>();
    }

    public ArrayList<Integer> getFileNames(String fileName) {
        if (allData.containsKey(fileName))
            return allData.get(fileName);
        return new ArrayList<>();
    }

    public void addFileName(String word, Integer address) {
        if (!allData.containsKey(word))
            allData.put(word, new ArrayList<>());
        if (!allData.get(word).contains(address))
            allData.get(word).add(address);
    }
}
