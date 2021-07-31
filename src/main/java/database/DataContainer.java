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
        return allData.get(searchedWord);

    }

    public HashMap<String, HashSet<Integer>> getAllData() {
        return allData;
    }

    public HashSet<Integer> getWordAddresses(String word) {
        return allData.get(word);
    }

}
