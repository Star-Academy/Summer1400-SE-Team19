package words;

import java.util.ArrayList;

public class NegativeWord implements Word {
    private final String word;

    public NegativeWord(String word) {
        this.word = word.substring(1);
    }

    @Override
    public String getWordInString() {
        return word;
    }

    @Override
    public void action(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult) {
        userSearchResult.removeAll(wordSearchResult);
    }
}
