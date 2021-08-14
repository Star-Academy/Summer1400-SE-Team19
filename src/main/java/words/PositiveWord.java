package words;

import java.util.HashSet;

public class PositiveWord implements Word {
    private static final int PRIORITY = 1;
    private final String word;
    private HashSet<Integer> searchResultOfWord;

    public PositiveWord(String word) {
        this.word = word.substring(1);

    }

    @Override
    public String getWordAsString() {
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
