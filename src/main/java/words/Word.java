package words;

import java.util.HashSet;

public class Word implements IWord {
    private static final int PRIORITY = 1;
    private final String word;
    private HashSet<Integer> searchResultOfWord;

    public Word(String word) {
        this.word = word.substring(1);

    }
    @Override
    public String getWordInString() {
        return word;
    }


    @Override
    public int getPriority() {
        return PRIORITY;
    }

}
