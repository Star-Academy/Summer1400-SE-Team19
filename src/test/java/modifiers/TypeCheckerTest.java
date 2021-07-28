package modifiers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class TypeCheckerTest {

    @Test
    public void makeAppropriateObjectsTest() {
        ArrayList<String> testingWords = new ArrayList<>(Arrays.asList("+positive", "neutralWord", "-negative"));
        TypeChecker typeChecker = new TypeChecker();
        ArrayList<Word> result = typeChecker.separateWords(testingWords);

        Assertions.assertEquals(result.size(), 3);

        Assertions.assertTrue(result.get(0) instanceof PositiveWord);
        Assertions.assertTrue(result.get(1) instanceof NeutralWord);
        Assertions.assertTrue(result.get(2) instanceof NegativeWord);
    }

    @Test
    public void setWordsInOrderTest() {
        ArrayList<String> wordsNotInOrder =
                new ArrayList<>(Arrays.asList("+positiveOne", "-negativeOne", "+positiveTwo", "neutralOne", "-negativeTwo"));
        TypeChecker typeChecker = new TypeChecker();
        ArrayList<Word> wordsInOrder = typeChecker.separateWords(wordsNotInOrder);

        Assertions.assertEquals(wordsInOrder.size(), 5);

        Assertions.assertTrue(wordsInOrder.get(0) instanceof PositiveWord);
        Assertions.assertTrue(wordsInOrder.get(1) instanceof PositiveWord);
        Assertions.assertTrue(wordsInOrder.get(2) instanceof NeutralWord);
        Assertions.assertTrue(wordsInOrder.get(3) instanceof NegativeWord);
        Assertions.assertTrue(wordsInOrder.get(4) instanceof NegativeWord);

    }
}
