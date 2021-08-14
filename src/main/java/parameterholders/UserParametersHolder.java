package parameterholders;

import modifiers.Searcher;
import modifiers.TypeChecker;
import parameterholders.abstraction.UserInterfaceParametersHolder;
import modifiers.abstraction.Filter;

import java.util.HashSet;
import java.util.Scanner;

public class UserParametersHolder implements UserInterfaceParametersHolder {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private modifiers.abstraction.Filter filter;
    private HashSet<Integer> result;
    private Searcher searcher;

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

    @Override
    public Searcher getSearcher() {
        return searcher;
    }

    @Override
    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }
}
