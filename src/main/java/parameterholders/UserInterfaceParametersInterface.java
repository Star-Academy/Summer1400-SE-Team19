package parameterholders;

import modifiers.Filter;
import modifiers.TypeChecker;

import java.util.HashSet;
import java.util.Scanner;

public interface UserInterfaceParametersInterface {
    Filter getFilter();

    void setFilter(Filter filter);

    HashSet<Integer> getResult();

    void setResult(HashSet<Integer> result);

    TypeChecker getTypeChecker();

    void setTypeChecker(TypeChecker typeChecker);

    Scanner getScanner();

    void setScanner(Scanner scanner);
}
