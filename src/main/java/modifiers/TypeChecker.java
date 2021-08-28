package modifiers;

import parameterholders.TypeCheckerParameters;
import words.IWord;
import words.Word;

import java.util.ArrayList;

public class TypeChecker {
    private final ArrayList<IWord> positiveWords;
    private final ArrayList<IWord> negativeWords;
    private final ArrayList<IWord> neutralWords;

    public TypeChecker(TypeCheckerParameters typeCheckerParameters) {
        positiveWords = typeCheckerParameters.getPositiveWords();
        negativeWords = typeCheckerParameters.getNegativeWords();
        neutralWords = typeCheckerParameters.getNeutralWords();
    }

    public void separateWords(ArrayList<String> words) {
        for (String word : words) {
            checkWordCondition(word);
        }
    }

    private void checkWordCondition(String word) {
        if (word.charAt(0) == '+') positiveWords.add(new Word(word.substring(1)));
        else if (word.charAt(0) == '-') negativeWords.add(new Word(word.substring(1)));
        else neutralWords.add(new Word(word));
    }

    public ArrayList<IWord> getPositiveWords() {
        return positiveWords;
    }

    public ArrayList<IWord> getNeutralWords() {
        return neutralWords;
    }

    public ArrayList<IWord> getNegativeWords() {
        return negativeWords;
    }
}
