package words;

import java.util.HashSet;

public interface Word {
    int getPriority();
    void filter(HashSet<Integer> userSearchResult);
    String getWordInString();
    void setSearchResult(HashSet<Integer> searchResultOfWord);
}
