package words;

import java.util.ArrayList;

public class NegativeWordAction extends Word  {
    static {
        priority = 3;
    }

    public NegativeWordAction(String word) {
        this.word = word.substring(1);
    }

    @Override
    public void filter(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult) {
        userSearchResult.removeAll(wordSearchResult);
    }

}
