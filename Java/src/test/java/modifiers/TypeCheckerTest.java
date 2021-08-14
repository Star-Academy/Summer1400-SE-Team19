package modifiers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TypeCheckerTest {
    @Mock
    private TypeCheckerParametersInterface parameters;

    @BeforeEach
    public void initBeforeEachTest() {
        when(parameters.getWordsInObject()).thenReturn(new ArrayList<>());
    }

    @Test
    public void makeAppropriateObjectTest() {
        ArrayList<String> demoWordsInString = new ArrayList<>(Arrays.asList("+positiveWord", "neutralWord", "-negativeWord"));
        TypeChecker typeChecker = new TypeChecker(parameters);
        ArrayList<Word> wordsInObject = typeChecker.separateWords(demoWordsInString);
        Assertions.assertEquals(wordsInObject.size(), 3);
        Assertions.assertAll(
                () -> Assertions.assertTrue(wordsInObject.get(0) instanceof PositiveWord),
                () -> Assertions.assertTrue(wordsInObject.get(1) instanceof NeutralWord),
                () -> Assertions.assertTrue(wordsInObject.get(2) instanceof NegativeWord)
        );
    }

    @Test
    public void putWordsInOrderTest() {
        ArrayList<String> demoWordsInString = new ArrayList<>(
                Arrays.asList("-negativeWordTwo", "+positiveWordOne",
                        "-negativeWordThree", "-negativeWordOne",
                        "+positiveWordTwo", "neutralWordTwo"));

        TypeChecker typeChecker = new TypeChecker(parameters);
        ArrayList<Word> wordsInObject = typeChecker.separateWords(demoWordsInString);
        Assertions.assertEquals(wordsInObject.size(), 6);
        Assertions.assertAll(
                () -> Assertions.assertTrue(wordsInObject.get(0) instanceof PositiveWord),
                () -> Assertions.assertTrue(wordsInObject.get(1) instanceof PositiveWord),
                () -> Assertions.assertTrue(wordsInObject.get(2) instanceof NeutralWord),
                () -> Assertions.assertTrue(wordsInObject.get(3) instanceof NegativeWord),
                () -> Assertions.assertTrue(wordsInObject.get(4) instanceof NegativeWord),
                () -> Assertions.assertTrue(wordsInObject.get(5) instanceof NegativeWord)
        );
    }
}
