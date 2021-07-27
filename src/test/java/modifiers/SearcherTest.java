package modifiers;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import words.NegativeWord;

class SearcherTest {

    @Mock
    DataContainer dataContainer;
    @Mock
    NegativeWord negativeWord1;

    @BeforeEach
    public void init() {
        Mock.init();
        dataContainer.addFileName("wow", 222);
    }

    @Test
    void search() {
        Assertions.assertEquals(dataContainer.getFilesNameWithSearchedWord("wow").size(), 1);
    }
}