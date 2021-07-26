package words;

import java.util.ArrayList;

public class PositiveWordAction extends Word {
    static {
        priority = 2;
    }

    public PositiveWordAction(String word) {
        this.word = word.substring(1);
    }

    @Override
    public void action(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult) {
        userSearchResult.retainAll(wordSearchResult);
    }

}
