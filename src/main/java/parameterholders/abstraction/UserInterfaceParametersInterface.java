package parameterholders.abstraction;

import modifiers.Searcher;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;

import java.util.HashSet;
import java.util.Scanner;

public interface UserInterfaceParametersInterface {
    FilterInterface getFilter();

    void setFilter(FilterInterface filter);

    HashSet<Integer> getResult();

    void setResult(HashSet<Integer> result);

    TypeChecker getTypeChecker();

    void setTypeChecker(TypeChecker typeChecker);

    Scanner getScanner();

    void setScanner(Scanner scanner);

    Searcher getSearcher();

    void setSearcher(Searcher searcher);
}
