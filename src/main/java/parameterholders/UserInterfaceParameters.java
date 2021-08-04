package parameterholders;

import modifiers.Searcher;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;
import parameterholders.abstraction.UserInterfaceParametersInterface;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParameters implements UserInterfaceParametersInterface {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private FilterInterface filter;
    private HashSet<Integer> result;
    private Searcher searcher;

    @Override
    public FilterInterface getFilter() {
        return filter;
    }

    @Override
    public void setFilter(FilterInterface filter) {
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

    @Override
    public Searcher getSearcher() {
        return searcher;
    }

    @Override
    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }
}
