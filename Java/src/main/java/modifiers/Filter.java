package modifiers;

import words.Word;

import java.util.HashSet;

public class Filter implements modifiers.abstraction.Filter {
    private void filterPositive(Word word, HashSet<Integer> result) {
        result.addAll(word.getSearchResult());
    }

    private void filterNeutral(Word word, HashSet<Integer> result) {
        if (result.size() == 0) result.addAll(word.getSearchResult());
        else result.retainAll(word.getSearchResult());
    }

    private void filterNegative(Word word, HashSet<Integer> result) {
        result.removeAll(word.getSearchResult());
    }

    @Override
    public void filter(Word word, HashSet<Integer> result) {
        if (word.getPriority() == 1) filterPositive(word, result);
        else if (word.getPriority() == 2) filterNeutral(word, result);
        else if (word.getPriority() == 3) filterNegative(word, result);

    }

}
