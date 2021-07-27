package model.words;

import java.util.HashSet;

public class NegativeWord implements Word {
    private static final int priority = 3;
    private final String word;
    private  HashSet<Integer> searchResultOfWord;

    public NegativeWord(String word) {
        this.word = word.substring(1);
    }

    @Override
    public void filter(HashSet<Integer> userSearchResult) {
        userSearchResult.removeAll(this.searchResultOfWord);
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
        return priority;
    }
}
