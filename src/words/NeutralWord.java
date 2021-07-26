package words;

import java.util.ArrayList;

public class NeutralWord implements Word {
    private final String word;

    public NeutralWord(String word) {
        this.word = word;
    }

    @Override
    public void action(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult) {
        userSearchResult.retainAll(wordSearchResult);
    }

    @Override
    public String getWordInString() {
        return word;
    }
}
