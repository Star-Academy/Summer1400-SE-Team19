package parameterholders.abstraction;

import modifiers.DataCollector;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;

import java.util.HashSet;
import java.util.Scanner;

public interface UserInterfaceParametersInterface {
    FilterInterface getPositiveFilter();

    FilterInterface getNegativeFilter();

    FilterInterface getNeutralFilter();

    void setPositiveWordFilter(FilterInterface positiveWordFilter);

    void setNeutralWordFilter(FilterInterface positiveWordFilter);

    void setNegativeWordFilter(FilterInterface positiveWordFilter);

    HashSet<Integer> getResult();

    void setResult(HashSet<Integer> result);

    TypeChecker getTypeChecker();

    void setTypeChecker(TypeChecker typeChecker);

    Scanner getScanner();

    void setScanner(Scanner scanner);

    DataCollector getSearcher();

    void setSearcher(DataCollector dataCollector);
}
