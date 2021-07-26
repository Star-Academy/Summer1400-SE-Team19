package words;

import java.util.ArrayList;

public interface Word {
    void action(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult);
    String getWordInString();
}
