package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.MergerParametersInterface;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class MergerParametersTest {

    private static final MergerParametersInterface mergerParametersInterface = new MergerParameters();
    @Mock
    private static HashSet<Integer> integerHashSet;


    @BeforeAll
    public static void init() {
        mergerParametersInterface.setHashSet(integerHashSet);
    }

    @Test
    public void getHashSetTest() {
        mergerParametersInterface.setHashSet(integerHashSet);
        Assertions.assertNotNull(mergerParametersInterface.getHashSet());
        Assertions.assertEquals(mergerParametersInterface.getHashSet(), integerHashSet);
    }
}
