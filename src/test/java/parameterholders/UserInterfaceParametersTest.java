package parameterholders;

import modifiers.Filter;
import modifiers.TypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParametersTest {

    private UserInterfaceParameters userInterfaceParameters = new UserInterfaceParameters();
    private TypeChecker typeChecker;
    private Scanner scanner;
    private modifiers.abstraction.Filter filter = new Filter();
    private HashSet<Integer> result = new HashSet<>();

    @Test
    public void setTypeCheckerTest() {
        userInterfaceParameters.setTypeChecker(typeChecker);
    }

    @Test
    public void setScannerTest() {
        userInterfaceParameters.setScanner(scanner);
    }

    @Test
    public void setFilterTest() {
        userInterfaceParameters.setFilter(filter);
    }

    @Test
    public void setResultTest() {
        userInterfaceParameters.setResult(result);
    }

    @Test
    public void getTypeCheckerTest() {
        userInterfaceParameters.setTypeChecker(typeChecker);
        Assertions.assertNull(userInterfaceParameters.getTypeChecker());
        Assertions.assertEquals(userInterfaceParameters.getTypeChecker(), typeChecker);
    }

    @Test
    public void getScannerTest() {
        userInterfaceParameters.setScanner(scanner);
        Assertions.assertNull(userInterfaceParameters.getScanner());
        Assertions.assertEquals(userInterfaceParameters.getScanner(), scanner);
    }

    @Test
    public void getFilterTest() {
        userInterfaceParameters.setFilter(filter);
        Assertions.assertNotNull(userInterfaceParameters.getFilter());
        Assertions.assertEquals(userInterfaceParameters.getFilter(), filter);
    }

    @Test
    public void getResultTest() {
        userInterfaceParameters.setResult(result);
        Assertions.assertNotNull(userInterfaceParameters.getResult());
        Assertions.assertEquals(userInterfaceParameters.getResult(), result);
    }
}
