package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.TypeCheckerParametersHolder;
import words.Word;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TypeCheckerParametersTest {
    private final TypeCheckerParametersHolder typeCheckerParametersHolder = new TypeCheckerParameters();
    @Mock
    private ArrayList<Word> wordArrayList;


    @Test
    public void setWordsInObjectTest() {
        typeCheckerParametersHolder.setWordsInObject(wordArrayList);
        Assertions.assertEquals(wordArrayList, typeCheckerParametersHolder.getWordsInObject());
    }

    @Test
    public void getWordsInObjectTest() {
        typeCheckerParametersHolder.setWordsInObject(wordArrayList);
        Assertions.assertNotNull(typeCheckerParametersHolder.getWordsInObject());
        Assertions.assertEquals(wordArrayList, typeCheckerParametersHolder.getWordsInObject());
    }
}
