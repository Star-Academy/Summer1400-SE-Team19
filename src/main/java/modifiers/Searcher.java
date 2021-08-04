package modifiers;

import database.DataContainer;
import words.Word;

import java.util.ArrayList;
import java.util.HashSet;

public class Searcher {
    private DataContainer dataContainer;

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public void search(ArrayList<Word> words) {
        for (Word word : words) {
            String wordString = word.getWordAsString();
            HashSet<Integer> searchResult = dataContainer.getFilesNameWithSearchedWord(wordString);
            if (searchResult == null)
                searchResult = new HashSet<>();
            word.setSearchResult(searchResult);
        }
    }

}
