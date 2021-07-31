package database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class FileReaderTest {

    @Mock
    File file;
    @Mock
    DataContainer dataContainer;

    @BeforeEach
    public void init() {
        when(file.getName()).thenReturn("1");
    }

    @Test
    public void avoidNonAlphabeticalSignsTest() {
        FileReader fileReader = new FileReader(dataContainer);
        fileReader.setFile(file);
        try {
            fileReader.setScanner(new Scanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String input = "one two three";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
