package parameterholders.abstraction;

import words.IWord;

import java.util.ArrayList;

public interface TypeCheckerParametersInterface {
    ArrayList<IWord> getPositiveWords();

    ArrayList<IWord> getNegativeWords();

    ArrayList<IWord> getNeutralWords();
}
