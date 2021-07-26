import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
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

            if (word.charAt(0) == '+') wordInObject = new PositiveWord(word);
            else if (word.charAt(0) == '-') wordInObject = new NegativeWord(word);
            else wordInObject = new NeutralWord(word);

            this.words.add(wordInObject);
        }
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
