package parameterholders;

import modifiers.Filter;
import modifiers.TypeChecker;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParameters {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private Filter filter;
    private HashSet<Integer> result;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public HashSet<Integer> getResult() {
        return result;
    }

    public void setResult(HashSet<Integer> result) {
        this.result = result;
    }

    public TypeChecker getTypeChecker() {
        return typeChecker;
    }

    public void setTypeChecker(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
