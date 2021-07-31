package database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FileReaderTest {
    @Mock
    Scanner scanner;
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
    }
}
