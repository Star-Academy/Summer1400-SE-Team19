import java.util.ArrayList;
import java.util.HashMap;

public class DataContainer {
    private static final DataContainer INSTANCE = new DataContainer();
    private final HashMap<String, ArrayList<Integer>> allData = new HashMap<>();

    private DataContainer() {}

    public static DataContainer getInstance() {
        return INSTANCE;
    }

    public ArrayList<Integer> getAddress(String fileName) {
        if (allData.containsKey(fileName))
            return allData.get(fileName);
        return new ArrayList<>();
    }

    public void addAddress(String word, Integer address) {
        if (!allData.containsKey(word))
            allData.put(word, new ArrayList<>());
        if (!allData.get(word).contains(address))
            allData.get(word).add(address);
    }
}