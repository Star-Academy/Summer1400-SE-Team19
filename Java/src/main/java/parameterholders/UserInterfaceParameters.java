package parameterholders;

import modifiers.TypeChecker;
import parameterholders.abstraction.UserInterfaceParametersInterface;
import modifiers.abstraction.Filter;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParameters implements UserInterfaceParametersInterface {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private modifiers.abstraction.Filter filter;
    private HashSet<Integer> result;

    @Override
    public Filter getFilter() {
        return filter;
    }

    @Override
    public void setFilter(modifiers.abstraction.Filter filter) {
        this.filter = filter;
    }

    @Override
    public HashSet<Integer> getResult() {
        return result;
    }

    @Override
    public void setResult(HashSet<Integer> result) {
        this.result = result;
    }

    @Override
    public TypeChecker getTypeChecker() {
        return typeChecker;
    }

    @Override
    public void setTypeChecker(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
