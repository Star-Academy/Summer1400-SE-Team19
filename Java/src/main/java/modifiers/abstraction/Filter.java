package modifiers.abstraction;

import words.Word;

import java.util.HashSet;

public interface Filter {
    void filter(Word word, HashSet<Integer> result);
}
