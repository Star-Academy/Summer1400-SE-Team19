package parameterholders;

import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.IWord;

import java.util.ArrayList;

public class TypeCheckerParameters implements TypeCheckerParametersInterface {
    private final ArrayList<IWord> positiveWords = new ArrayList<>();
    private final ArrayList<IWord> negativeWords = new ArrayList<>();
    private final ArrayList<IWord> neutralWords = new ArrayList<>();

    public ArrayList<IWord> getPositiveWords() {
        return positiveWords;
    }

    public ArrayList<IWord> getNegativeWords() {
        return negativeWords;
    }

    public ArrayList<IWord> getNeutralWords() {
        return neutralWords;
    }

}
