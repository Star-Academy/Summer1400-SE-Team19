package parameterholders;

import modifiers.DataCollector;
import modifiers.TypeChecker;
import modifiers.abstraction.FilterInterface;
import parameterholders.abstraction.UserInterfaceParametersInterface;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterfaceParameters implements UserInterfaceParametersInterface {
    private TypeChecker typeChecker;
    private Scanner scanner;
    private FilterInterface positiveWordFilter;
    private FilterInterface neutralWordFilter;
    private FilterInterface negativeWordFilter;

    private HashSet<Integer> result;
    private DataCollector dataCollector;

    @Override
    public FilterInterface getPositiveFilter() {
        return positiveWordFilter;
    }

    @Override
    public FilterInterface getNegativeFilter() {
        return  negativeWordFilter;
    }

    @Override
    public FilterInterface getNeutralFilter() {
        return neutralWordFilter;
    }

    @Override
    public void setPositiveWordFilter(FilterInterface positiveWordFilter) {
        this.positiveWordFilter = positiveWordFilter;
    }

    @Override
    public void setNeutralWordFilter(FilterInterface neutralWordFilter) {
        this.neutralWordFilter = neutralWordFilter;
    }

    @Override
    public void setNegativeWordFilter(FilterInterface negativeWordFilter) {
        this.negativeWordFilter = negativeWordFilter;
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
    public DataCollector getSearcher() {
        return dataCollector;
    }

    @Override
    public void setSearcher(DataCollector dataCollector) {
        this.dataCollector = dataCollector;
    }
}
