package modifiers;

import database.DataContainer;
import words.IWord;

import java.util.ArrayList;
import java.util.HashSet;

public class DataCollector {
    private DataContainer dataContainer;
    private ArrayList<HashSet<Integer>> wordSearchResult;

    public void setDataContainer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public ArrayList<HashSet<Integer>> collectData(ArrayList<IWord> words) {
        for (IWord word : words) {
            searchWordInDatabase(word);
        }
        return wordSearchResult;
    }

    private void searchWordInDatabase(IWord word) {
        String wordAsString = word.getWordInString();
        HashSet<Integer> searchResult = dataContainer.getFilesNameWithSearchedWord(wordAsString);
        if (searchResult == null) searchResult = new HashSet<>();
        wordSearchResult.add(searchResult);
    }

}
