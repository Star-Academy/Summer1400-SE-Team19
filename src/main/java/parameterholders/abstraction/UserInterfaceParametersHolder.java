package parameterholders.abstraction;

import modifiers.Searcher;
import modifiers.TypeChecker;
import modifiers.abstraction.Filter;

import java.util.HashSet;
import java.util.Scanner;

public interface UserInterfaceParametersHolder {
    Filter getFilter();

    void setFilter(Filter filter);

    HashSet<Integer> getResult();

    void setResult(HashSet<Integer> result);

    TypeChecker getTypeChecker();

    void setTypeChecker(TypeChecker typeChecker);

    Scanner getScanner();

    void setScanner(Scanner scanner);

    Searcher getSearcher();

    void setSearcher(Searcher searcher);
}
