package modifiers;

import words.Word;

import java.util.ArrayList;
import java.util.HashSet;

public class Merger {
    private final HashSet<Integer> result;
    private final Filter filter;

    public Merger() {
        result = new HashSet<>();
        filter = new Filter();
    }

    public HashSet<Integer> mergeSearchResult(ArrayList<Word> words) {
        for (Word word : words) {
            filter.filter(word, result);
        }
        return result;
    }

}
