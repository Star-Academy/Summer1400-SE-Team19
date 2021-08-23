package modifiers;

import modifiers.abstraction.FilterInterface;

import java.util.HashSet;
import java.util.Set;

public class FilterNeutralWords implements FilterInterface {
    @Override
    public Set<Integer> filter(HashSet<Integer> searchResultOfWord, HashSet<Integer> preResult) {
            var result = new HashSet<Integer>(preResult);
            if (result.size() != 0)
                result.retainAll(searchResultOfWord);
            else
                result.addAll(searchResultOfWord);
            return result;
        }
}
