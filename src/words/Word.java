package words;

import java.util.ArrayList;

public abstract class Word {
    protected static int priority;
    protected String word;

    public abstract void filter(ArrayList<Integer> wordSearchResult, ArrayList<Integer> userSearchResult);

    public String getWordInString() {
        return word;
    }

    public int getPriority() {
        return priority;
    }
}
