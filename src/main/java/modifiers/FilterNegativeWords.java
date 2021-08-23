package modifiers;

import modifiers.abstraction.FilterInterface;

import java.util.HashSet;
import java.util.Set;

public class FilterNegativeWords implements FilterInterface {
    @Override
    public Set<Integer> filter(HashSet<Integer> searchResultOfWord, HashSet<Integer> preResult) {
        preResult.removeAll(searchResultOfWord);
        return preResult;
    }
}
