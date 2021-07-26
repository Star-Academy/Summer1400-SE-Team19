package words;

import java.util.ArrayList;

public class NeutralWordAction extends Word  {
    static {
        priority = 1;
    }

    public NeutralWordAction(String word) {
        this.word = word;
    }

    @Override
    public void action(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult) {
        userSearchResult.retainAll(wordSearchResult);
    }

}
