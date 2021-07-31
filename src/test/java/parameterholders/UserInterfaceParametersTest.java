package parameterholders;

import modifiers.TypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.UserInterfaceParametersInterface;

import java.util.HashSet;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class UserInterfaceParametersTest {

    private final UserInterfaceParametersInterface userInterfaceParametersInterface = new UserInterfaceParameters();
    @Mock
    private TypeChecker typeChecker;
    @Mock
    private modifiers.abstraction.Filter filter;
    @Mock
    private HashSet<Integer> result;

    private final Scanner scanner = new Scanner(System.in);

    @BeforeEach
    public void init() {
        userInterfaceParametersInterface.setTypeChecker(typeChecker);
        userInterfaceParametersInterface.setScanner(scanner);
        userInterfaceParametersInterface.setFilter(filter);
        userInterfaceParametersInterface.setResult(result);
    }


    @Test
    public void getTypeCheckerTest() {
        Assertions.assertNotNull(userInterfaceParametersInterface.getTypeChecker());
        Assertions.assertEquals(userInterfaceParametersInterface.getTypeChecker(), typeChecker);
    }

    @Test
    public void getScannerTest() {
        Assertions.assertNotNull(userInterfaceParametersInterface.getScanner());
        Assertions.assertEquals(userInterfaceParametersInterface.getScanner(), scanner);
    }

    @Test
    public void getFilterTest() {
        Assertions.assertNotNull(userInterfaceParametersInterface.getFilter());
        Assertions.assertEquals(userInterfaceParametersInterface.getFilter(), filter);
    }

    @Test
    public void getResultTest() {
        Assertions.assertNotNull(userInterfaceParametersInterface.getResult());
        Assertions.assertEquals(userInterfaceParametersInterface.getResult(), result);
    }
}
