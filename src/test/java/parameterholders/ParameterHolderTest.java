package parameterholders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.ParameterHolderInterface;

@ExtendWith(MockitoExtension.class)
public class ParameterHolderTest {
    private ParameterHolderInterface parameterHolderInterface = new ParameterHolder();
    @Mock
    private DataContainerParameters dataContainerParametersInterface;
    @Mock
    private DataProviderParameters dataProviderParametersInterface;
    @Mock
    private MergerParameters mergerParametersInterface;
    @Mock
    private TypeCheckerParameters typeCheckerParametersInterface;
    @Mock
    private UserInterfaceParameters userInterfaceParametersInterface;


    @BeforeEach
    public static void init(){

    }
}
