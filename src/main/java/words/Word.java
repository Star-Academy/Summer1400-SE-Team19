package words;

import java.util.HashSet;

public interface Word {
    int getPriority();

    String getWordInString();

    void setSearchResult(HashSet<Integer> searchResultOfWord);

    HashSet<Integer> getSearchResult();
}
