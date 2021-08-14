import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParameterHolderInitializerTest {
    private ParameterHolderInitializer parameterHolderInitializer;

    @Test
    public void initializationTest() {
        parameterHolderInitializer = new ParameterHolderInitializer();
        Assertions.assertNotNull(parameterHolderInitializer.getParameterHolder());
    }

}
