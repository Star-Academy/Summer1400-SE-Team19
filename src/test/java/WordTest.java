import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class WordTest {

    private final HashSet<Integer> demoSearchResult = new HashSet<>();

    @Test
    public void positiveWordTest() {
        String wordAsString = "+chair";
        PositiveWord positiveWord = new PositiveWord(wordAsString);
        Assertions.assertEquals(1, positiveWord.getPriority());
        Assertions.assertEquals("chair", positiveWord.getWordAsString());
        positiveWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, positiveWord.getSearchResult());
    }

    @Test
    public void neutralWordTest() {
        String wordAsString = "rider";
        NeutralWord neutralWord = new NeutralWord(wordAsString);
        Assertions.assertEquals(2, neutralWord.getPriority());
        Assertions.assertEquals("rider", neutralWord.getWordAsString());
        neutralWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, neutralWord.getSearchResult());
    }

    @Test
    public void negativeWordTest() {
        String wordAsString = "-negative";
        NegativeWord negativeWord = new NegativeWord(wordAsString);
        Assertions.assertEquals(3, negativeWord.getPriority());
        Assertions.assertEquals("negative", negativeWord.getWordAsString());
        negativeWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, negativeWord.getSearchResult());
    }
}
