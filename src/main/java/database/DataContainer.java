package database;

import parameterholders.DataContainerParameters;
import parameterholders.abstraction.DataContainerParametersInterface;

import java.util.HashMap;
import java.util.HashSet;

public class DataContainer {
    private final HashMap<String, HashSet<Integer>> allData;

    public DataContainer(DataContainerParametersInterface dataContainerParameters) {
        allData = dataContainerParameters.getAllData();
    }

    public HashSet<Integer> getFilesNameWithSearchedWord(String searchedWord) {
        if (allData.containsKey(searchedWord)) return allData.get(searchedWord);
        return new HashSet<>();
    }

    public HashSet<Integer> getWordAddresses(String word) {
        return allData.get(word);
    }

    public HashMap<String, HashSet<Integer>> getAllData() {
        return allData;
    }
}
