package words;

import java.util.HashSet;

public class NeutralWord implements Word {
    private static final int PRIORITY = 2;
    private final String word;
    private HashSet<Integer> searchResultOfWord;

    public NeutralWord(String word) {
        this.word = word;
    }

    @Override
    public void filter(HashSet<Integer> userSearchResult) {
        if (userSearchResult.size() == 0) userSearchResult.addAll(searchResultOfWord);
        else userSearchResult.retainAll(searchResultOfWord);
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
