package words;

import java.util.ArrayList;

public class PositiveWord implements Word {
  private final String word;

    public PositiveWord(String word) {
        this.word = word.substring(1);
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
