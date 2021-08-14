package parameterholders;

import parameterholders.abstraction.TypeCheckerParametersHolder;
import words.Word;

import java.util.ArrayList;

public class TypeCheckerParameters implements TypeCheckerParametersHolder {
    private ArrayList<Word> wordsInObject;

    @Override
    public ArrayList<Word> getWordsInObject() {
        return wordsInObject;
    }

    @Override
    public void setWordsInObject(ArrayList<Word> wordsInObject) {
        this.wordsInObject = wordsInObject;
    }
}
