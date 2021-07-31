package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private final DataContainer dataContainer;
    private File file;
    private Scanner scanner;

    public FileReader(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }


    public void read() throws FileNotFoundException {
        int fileName = Integer.parseInt(file.getName());
        while (scanner.hasNext()) {
            addWordToDataContainer(fileName, scanner);
        }
    }

    private void addWordToDataContainer(int fileName, Scanner scanner) {
        String word = scanner.next().toLowerCase();
        word = word.replaceAll("[^a-zA-Z0-9]", "");
        dataContainer.addFileName(word, fileName);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
