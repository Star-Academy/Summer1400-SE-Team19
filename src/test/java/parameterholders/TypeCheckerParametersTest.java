package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import words.Word;

import java.util.ArrayList;

public class TypeCheckerParametersTest {
    private TypeCheckerParameters typeCheckerParameters = new TypeCheckerParameters();
    private ArrayList<Word> wordArrayList = new ArrayList<>();


    @Test
    public void setWordsInObjectTest() {
        typeCheckerParameters.setWordsInObject(wordArrayList);
    }

    @Test
    public void getWordsInObjectTest() {
        typeCheckerParameters.setWordsInObject(wordArrayList);
        Assertions.assertNotNull(typeCheckerParameters.getWordsInObject());
        Assertions.assertEquals(wordArrayList, typeCheckerParameters.getWordsInObject());
    }
}
