package parameterholders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parameterholders.abstraction.MergerParametersInterface;

import java.util.HashSet;

public class MergerParametersTest {

    private MergerParametersInterface mergerParametersInterface = new MergerParameters();
    private HashSet<Integer> integerHashSet = new HashSet<>();


    @Test
    public void setHashSetTest() {
        mergerParametersInterface.setHashSet(integerHashSet);
    }

    @Test
    public void getHashSetTest() {
        mergerParametersInterface.setHashSet(integerHashSet);
        Assertions.assertNotNull(mergerParametersInterface.getHashSet());
        Assertions.assertEquals(mergerParametersInterface.getHashSet(), integerHashSet);
    }
}
