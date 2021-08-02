package modifiers;

import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.ArrayList;
import java.util.Comparator;

public class TypeChecker {
    private final ArrayList<Word> wordsInObject;

    public TypeChecker(TypeCheckerParametersInterface typeCheckerParametersInterface) {
        wordsInObject = typeCheckerParametersInterface.getWordsInObject();
    }

    public ArrayList<Word> separateWords(ArrayList<String> words) {
        for (String word : words) {
            Word wordInObject = checkWordCondition(word);
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
        ArrayList<Word> result = new ArrayList<>(wordsInObject);
        Comparator<Word> comparator = Comparator.comparing(Word::getPriority);
        result.sort(comparator);
        return result;
    }
}
