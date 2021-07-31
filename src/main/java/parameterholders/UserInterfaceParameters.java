package parameterholders;

import modifiers.TypeChecker;
import modifiers.abstraction.Filter;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParameters {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private modifiers.abstraction.Filter filter;
    private HashSet<Integer> result;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(modifiers.abstraction.Filter filter) {
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
