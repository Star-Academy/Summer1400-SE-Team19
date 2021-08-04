package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.TypeCheckerParametersInterface;
import words.Word;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TypeCheckerParametersTest {
    private final TypeCheckerParametersInterface typeCheckerParametersInterface = new TypeCheckerParameters();
    @Mock
    private ArrayList<Word> wordArrayList;


    @Test
    public void setWordsInObjectTest() {
        typeCheckerParametersInterface.setWordsInObject(wordArrayList);
        Assertions.assertEquals(wordArrayList, typeCheckerParametersInterface.getWordsInObject());
    }

    @Test
    public void getWordsInObjectTest() {
        typeCheckerParametersInterface.setWordsInObject(wordArrayList);
        Assertions.assertNotNull(typeCheckerParametersInterface.getWordsInObject());
        Assertions.assertEquals(wordArrayList, typeCheckerParametersInterface.getWordsInObject());
    }
}
