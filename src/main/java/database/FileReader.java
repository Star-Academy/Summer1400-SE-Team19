package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private File file;
    private final DataContainer dataContainer;
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
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
