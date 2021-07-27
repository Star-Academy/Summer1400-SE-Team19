package model.parameterholders;

import model.words.Word;

import java.util.ArrayList;

public class TypeCheckerParameters {
    private ArrayList<Word> wordsInObject;

    public ArrayList<Word> getWordsInObject() {
        return wordsInObject;
    }

    public void setWordsInObject(ArrayList<Word> wordsInObject) {
        this.wordsInObject = wordsInObject;
    }
}
