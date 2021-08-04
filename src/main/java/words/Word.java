package words;

import java.util.HashSet;

public interface Word {
    int getPriority();

    String getWordAsString();

    void setSearchResult(HashSet<Integer> searchResultOfWord);

    HashSet<Integer> getSearchResult();

}
