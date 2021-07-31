package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.Word;

import java.util.ArrayList;

public class TypeCheckerParametersTest {
    private TypeCheckerParametersInterface typeCheckerParametersInterface = new TypeCheckerParameters();
    private ArrayList<Word> wordArrayList = new ArrayList<>();


    @Test
    public void setWordsInObjectTest() {
        typeCheckerParametersInterface.setWordsInObject(wordArrayList);
    }

    @Test
    public void getWordsInObjectTest() {
        typeCheckerParametersInterface.setWordsInObject(wordArrayList);
        Assertions.assertNotNull(typeCheckerParametersInterface.getWordsInObject());
        Assertions.assertEquals(wordArrayList, typeCheckerParametersInterface.getWordsInObject());
    }
}
