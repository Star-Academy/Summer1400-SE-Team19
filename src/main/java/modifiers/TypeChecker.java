package modifiers;

import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.ArrayList;
import java.util.Comparator;

public class TypeChecker {
    private final ArrayList<Word> wordsInObject;

    public TypeChecker() {
        wordsInObject = new ArrayList<>();
    }

    public ArrayList<Word> separateWords(ArrayList<String> words) {
        for (String word : words) {
            Word wordInObject;

            if (word.charAt(0) == '+') wordInObject = new PositiveWord(word);
            else if (word.charAt(0) == '-') wordInObject = new NegativeWord(word);
            else wordInObject = new NeutralWord(word);
            wordsInObject.add(wordInObject);
        }
        return sortResult(wordsInObject);
    }

    private ArrayList<Word> sortResult(ArrayList<Word> wordsInObject) {
        Comparator<Word> comparator = Comparator.comparing(Word::getPriority).reversed();
        wordsInObject.sort(comparator);
        return wordsInObject;
    }
}
