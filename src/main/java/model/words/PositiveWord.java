package model.words;

import java.util.HashSet;

public class PositiveWord implements Word {
    private static final int PRIORITY = 1;
    private final String word;
    private HashSet<Integer> searchResultOfWord;

    public PositiveWord(String word) {
        this.word = word.substring(1);

    }

    @Override
    public void filter(HashSet<Integer> userSearchResult) {
        userSearchResult.retainAll(this.searchResultOfWord);
    }

    @Override
    public String getWordInString() {
        return word;
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