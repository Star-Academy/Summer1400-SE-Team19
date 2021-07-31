package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class MergerParametersTest {

    private MergerParameters mergerParameters = new MergerParameters();
    private HashSet<Integer> integerHashSet = new HashSet<>();


    @Test
    public void setHashSetTest() {
        mergerParameters.setHashSet(integerHashSet);
    }

    @Test
    public void getHashSetTest() {
        mergerParameters.setHashSet(integerHashSet);
        Assertions.assertNotNull(mergerParameters.getHashSet());
        Assertions.assertEquals(mergerParameters.getHashSet(), integerHashSet);
    }
}
