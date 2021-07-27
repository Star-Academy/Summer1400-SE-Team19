package modifiers;

import database.DataContainer;
import words.Word;

import java.util.ArrayList;
import java.util.HashSet;

public class Merger {
    private final HashSet<Integer> result = new HashSet<>();

    public HashSet<Integer> mergeSearchResult(ArrayList<Word> words) {

        for (Word word : words) {
            word.filter(result);
        }
        return result;
    }

}