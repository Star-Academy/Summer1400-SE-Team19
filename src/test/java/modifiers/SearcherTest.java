package modifiers;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import words.NegativeWord;

@ExtendWith(MockitoExtension.class)
class SearcherTest {

    @Mock
    DataContainer dataContainer;
    @Mock
    NegativeWord negativeWord1;

    @BeforeEach
    public void init() {

    }

    @Test
    void search() {
        dataContainer.addFileName("wow", 222);
        Assertions.assertEquals(dataContainer.getFilesNameWithSearchedWord("wow").size(), 1);
    }
}