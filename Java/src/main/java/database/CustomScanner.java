package database;

import java.io.File;
import java.util.Scanner;

public class CustomScanner {
    private Scanner scanner;
    private File file;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFileName() {
        return file.getName();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getNext() {
        return scanner.next();
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }
}
