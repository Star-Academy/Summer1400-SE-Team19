package modifiers;

import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.HashSet;

public class Filter {
    private void filterPositive(PositiveWord word, HashSet<Integer> result) {
        result.addAll(word.getSearchResult());
    }

    private void filterNeutral(NeutralWord word, HashSet<Integer> result) {
        if (result.size() == 0) result.addAll(word.getSearchResult());
        else result.retainAll(word.getSearchResult());
    }

    private void filterNegative(NegativeWord word, HashSet<Integer> result) {
        result.removeAll(word.getSearchResult());
    }

    public void filter(Word word, HashSet<Integer> result) {
        if (word instanceof PositiveWord) filterPositive((PositiveWord) word, result);
        else if (word instanceof NegativeWord) filterNegative((NegativeWord) word, result);
        else filterNeutral((NeutralWord) word, result);
    }

}
