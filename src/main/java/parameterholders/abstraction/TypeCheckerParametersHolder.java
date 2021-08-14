package parameterholders.abstraction;

import words.Word;

import java.util.ArrayList;

public interface TypeCheckerParametersHolder {
    ArrayList<Word> getWordsInObject();

    void setWordsInObject(ArrayList<Word> wordsInObject);
}
