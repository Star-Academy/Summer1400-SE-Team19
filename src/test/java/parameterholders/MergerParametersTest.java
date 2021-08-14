package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.MergerParametersHolder;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class MergerParametersTest {

    private static final MergerParametersHolder MERGER_PARAMETERS_HOLDER = new MergerParameters();
    @Mock
    private static HashSet<Integer> integerHashSet;


    @BeforeAll
    public static void init() {
        MERGER_PARAMETERS_HOLDER.setHashSet(integerHashSet);
    }

    @Test
    public void getHashSetTest() {
        MERGER_PARAMETERS_HOLDER.setHashSet(integerHashSet);
        Assertions.assertNotNull(MERGER_PARAMETERS_HOLDER.getHashSet());
        Assertions.assertEquals(MERGER_PARAMETERS_HOLDER.getHashSet(), integerHashSet);
    }
}
