import words.NegativeWordAction;
import words.NeutralWordAction;
import words.PositiveWordAction;
import words.Word;

import java.util.ArrayList;

public class TypeChecker {
    ArrayList<Word> words;

    {
        words = new ArrayList<>();
    }

    public TypeChecker(ArrayList<String> words) {
        separateWords(words);
    }

    private void separateWords(ArrayList<String> words) {
        for (String word : words) {
            Word wordInObject;

            if (word.charAt(0) == '+') wordInObject = new PositiveWordAction(word);
            else if (word.charAt(0) == '-') wordInObject = new NegativeWordAction(word);
            else wordInObject = new NeutralWordAction(word);

            this.words.add(wordInObject);
        }
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
