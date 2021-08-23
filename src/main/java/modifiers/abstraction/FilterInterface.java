package modifiers.abstraction;

import words.IWord;

import java.util.HashSet;
import java.util.Set;

public interface FilterInterface {
    public Set<Integer> filter(HashSet<Integer> searchResultOfWord, HashSet<Integer> preResult);
}
