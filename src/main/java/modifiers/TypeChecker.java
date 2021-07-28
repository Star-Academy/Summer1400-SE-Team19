package modifiers;

import parameterholders.TypeCheckerParameters;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.ArrayList;
import java.util.Comparator;

public class TypeChecker {
    private final ArrayList<Word> wordsInObject;

    public TypeChecker(TypeCheckerParameters typeCheckerParameters) {
        wordsInObject = typeCheckerParameters.getWordsInObject();
    }

    public ArrayList<Word> separateWords(ArrayList<String> words) {
        for (String word : words) {
            Word wordInObject;
            wordInObject = checkWordCondition(word);
            wordsInObject.add(wordInObject);
        }
        return sortResult(wordsInObject);
    }

    private Word checkWordCondition(String word) {
        Word wordInObject;
        if (word.charAt(0) == '+') wordInObject = new PositiveWord(word);
        else if (word.charAt(0) == '-') wordInObject = new NegativeWord(word);
        else wordInObject = new NeutralWord(word);
        return wordInObject;
    }

    private ArrayList<Word> sortResult(ArrayList<Word> wordsInObject) {
        Comparator<Word> comparator = Comparator.comparing(Word::getPriority).reversed();
        wordsInObject.sort(comparator);
        return wordsInObject;
    }
}
