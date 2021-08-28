package database;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

public class FileReader {
    private final DataContainer dataContainer;
    private CustomScanner customScanner;

    public FileReader(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public void setCustomScanner(CustomScanner customScanner) {
        this.customScanner = customScanner;
    }

    public void read() throws FileNotFoundException {
        int fileName = Integer.parseInt(customScanner.getFileName());
        while (customScanner.hasNext()) {
            addWordToDataContainer(fileName);
        }
    }

    private void addWordToDataContainer(int fileName) {
        String word = customScanner.getNext().toLowerCase();
        word = word.replaceAll("[^a-zA-Z0-9]", "");
        addFileName(word, fileName);
    }

    private void addFileName(String word, Integer address) {
        HashMap<String, HashSet<Integer>> allData = dataContainer.getAllData();
        if (!allData.containsKey(word))  allData.put(word, new HashSet<>());
        dataContainer.getWordAddresses(word).add(address);
    }
}
