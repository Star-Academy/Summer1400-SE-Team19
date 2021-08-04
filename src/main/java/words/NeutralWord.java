package words;

import javax.naming.directory.SearchResult;
import java.util.HashSet;

public class NeutralWord implements Word {
    private static final int PRIORITY = 2;
    private final String word;
    private HashSet<Integer> searchResultOfWord;

    public NeutralWord(String word) {
        this.word = word;
    }

    @Override
    public String getWordInString() {
        return word;
    }

    @Override
    public HashSet<Integer> getSearchResult() {
     return searchResultOfWord;
    }

    @Override
    public void setSearchResult(HashSet<Integer> searchResultOfWord) {
        this.searchResultOfWord = searchResultOfWord;
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }
}
