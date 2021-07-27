package controller.modifiers;

import model.database.DataContainer;
import model.words.Word;

import java.util.ArrayList;
import java.util.HashSet;

public class Searcher {
    private final DataContainer dataContainer;

    public  Searcher(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    public void search(ArrayList<Word> words) {
        for (Word word : words) {
            String wordInString = word.getWordInString();
            HashSet<Integer> searchResult = dataContainer.getFilesNameWithSearchedWord(wordInString);
            word.setSearchResult(searchResult);
        }
    }

}
