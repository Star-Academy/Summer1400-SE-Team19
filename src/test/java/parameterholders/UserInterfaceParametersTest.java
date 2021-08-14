package parameterholders;

import modifiers.TypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import parameterholders.abstraction.UserInterfaceParametersHolder;

import java.util.HashSet;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class UserInterfaceParametersTest {

    private final UserInterfaceParametersHolder userInterfaceParametersHolder = new UserParametersHolder();
    @Mock
    private TypeChecker typeChecker;
    @Mock
    private modifiers.abstraction.Filter filter;
    @Mock
    private HashSet<Integer> result;

    private final Scanner scanner = new Scanner(System.in);

    @BeforeEach
    public void init() {
        userInterfaceParametersHolder.setTypeChecker(typeChecker);
        userInterfaceParametersHolder.setScanner(scanner);
        userInterfaceParametersHolder.setFilter(filter);
        userInterfaceParametersHolder.setResult(result);
    }


    @Test
    public void getTypeCheckerTest() {
        Assertions.assertNotNull(userInterfaceParametersHolder.getTypeChecker());
        Assertions.assertEquals(userInterfaceParametersHolder.getTypeChecker(), typeChecker);
    }

    @Test
    public void getScannerTest() {
        Assertions.assertNotNull(userInterfaceParametersHolder.getScanner());
        Assertions.assertEquals(userInterfaceParametersHolder.getScanner(), scanner);
    }

    @Test
    public void getFilterTest() {
        Assertions.assertNotNull(userInterfaceParametersHolder.getFilter());
        Assertions.assertEquals(userInterfaceParametersHolder.getFilter(), filter);
    }

    @Test
    public void getResultTest() {
        Assertions.assertNotNull(userInterfaceParametersHolder.getResult());
        Assertions.assertEquals(userInterfaceParametersHolder.getResult(), result);
    }
}
