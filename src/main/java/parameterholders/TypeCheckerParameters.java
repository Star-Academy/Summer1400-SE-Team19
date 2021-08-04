package parameterholders;

import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.Word;

import java.util.ArrayList;

public class TypeCheckerParameters implements TypeCheckerParametersInterface {
    private ArrayList<Word> wordsInObject;

    public ArrayList<Word> getWordsInObject() {
        return wordsInObject;
    }

    public void setWordsInObject(ArrayList<Word> wordsInObject) {
        this.wordsInObject = wordsInObject;
    }
}
