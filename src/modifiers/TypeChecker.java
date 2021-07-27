package modifiers;

import words.NegativeWordAction;
import words.NeutralWordAction;
import words.PositiveWordAction;
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

            if (word.charAt(0) == '+') wordInObject = new PositiveWordAction(word);
            else if (word.charAt(0) == '-') wordInObject = new NegativeWordAction(word);
            else wordInObject = new NeutralWordAction(word);
            wordsInObject.add(wordInObject);
        }
        return sortResult(wordsInObject);
    }

    private ArrayList<Word> sortResult(ArrayList<Word> wordsInObject) {
        Comparator<Word> comparator = Comparator.comparing(Word::getPriority);
        wordsInObject.sort(comparator);
        return wordsInObject;
    }
}