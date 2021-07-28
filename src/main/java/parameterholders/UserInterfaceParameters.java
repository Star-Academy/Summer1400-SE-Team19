package parameterholders;

import modifiers.Merger;
import modifiers.TypeChecker;

import java.util.Scanner;

public class UserInterfaceParameters {
    private TypeChecker typeChecker;
    private Merger merger;
    private Scanner scanner;

    public TypeChecker getTypeChecker() {
        return typeChecker;
    }

    public void setTypeChecker(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    public Merger getMerger() {
        return merger;
    }

    public void setMerger(Merger merger) {
        this.merger = merger;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
