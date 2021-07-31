package parameterholders;

import modifiers.Filter;
import modifiers.TypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parameterholders.abstraction.UserInterfaceParametersInterface;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParametersTest {

    private UserInterfaceParametersInterface userInterfaceParametersInterface = new UserInterfaceParameters();
    private TypeChecker typeChecker;
    private Scanner scanner;
    private Filter filter = new Filter();
    private HashSet<Integer> result = new HashSet<>();

    @Test
    public void setTypeCheckerTest() {
        userInterfaceParametersInterface.setTypeChecker(typeChecker);
    }

    @Test
    public void setScannerTest() {
        userInterfaceParametersInterface.setScanner(scanner);
    }

    @Test
    public void setFilterTest() {
        userInterfaceParametersInterface.setFilter(filter);
    }

    @Test
    public void setResultTest() {
        userInterfaceParametersInterface.setResult(result);
    }

    @Test
    public void getTypeCheckerTest() {
        userInterfaceParametersInterface.setTypeChecker(typeChecker);
        Assertions.assertNull(userInterfaceParametersInterface.getTypeChecker());
        Assertions.assertEquals(userInterfaceParametersInterface.getTypeChecker(), typeChecker);
    }

    @Test
    public void getScannerTest() {
        userInterfaceParametersInterface.setScanner(scanner);
        Assertions.assertNull(userInterfaceParametersInterface.getScanner());
        Assertions.assertEquals(userInterfaceParametersInterface.getScanner(), scanner);
    }

    @Test
    public void getFilterTest() {
        userInterfaceParametersInterface.setFilter(filter);
        Assertions.assertNotNull(userInterfaceParametersInterface.getFilter());
        Assertions.assertEquals(userInterfaceParametersInterface.getFilter(), filter);
    }

    @Test
    public void getResultTest() {
        userInterfaceParametersInterface.setResult(result);
        Assertions.assertNotNull(userInterfaceParametersInterface.getResult());
        Assertions.assertEquals(userInterfaceParametersInterface.getResult(), result);
    }
}
