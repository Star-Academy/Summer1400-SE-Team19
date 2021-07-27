package database;

import java.util.HashMap;
import java.util.HashSet;

public class DataContainer {
    private final HashMap<String, HashSet<Integer>> allData;

    public DataContainer() {
        allData = new HashMap<>();
    }

    public HashSet<Integer> getFilesNameWithSearchedWord(String searchedWord) {
        if (allData.containsKey(searchedWord)) return allData.get(searchedWord);
        return new HashSet<>();
    }

    public void addFileName(String word, Integer address) {
        if (!allData.containsKey(word))  allData.put(word, new HashSet<>());

        allData.get(word).add(address);
    }
}
