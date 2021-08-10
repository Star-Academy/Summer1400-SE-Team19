package parameterholders.abstraction;

import words.Word;

import java.util.ArrayList;

public interface TypeCheckerParametersInterface {
    ArrayList<Word> getWordsInObject();

    void setWordsInObject(ArrayList<Word> wordsInObject);
}
