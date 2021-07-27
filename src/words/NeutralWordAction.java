package words;

import java.util.ArrayList;
import java.util.HashSet;

public class NeutralWordAction implements Word {
    private static final int PRIORITY = 2;
    private final String word;
    private  HashSet<Integer> searchResultOfWord;

    public NeutralWordAction(String word) {
        this.word = word;
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
