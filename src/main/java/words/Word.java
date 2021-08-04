package words;

import java.util.HashSet;

public interface Word {
    int getPriority();
    void setSearchResult(HashSet<Integer> searchResultOfWord);
    String getWordInString();
    HashSet<Integer> getSearchResult();
}
