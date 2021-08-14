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
    private final String positiveWordAsString = "+chair";
    private final String negativeWordAsString = "-negative";
    private final String neutralWordAsString = "rider";

    @Test
    public void positiveWordPriorityTest() {
        PositiveWord positiveWord = new PositiveWord(positiveWordAsString);
        Assertions.assertEquals(1, positiveWord.getPriority());
    }

    @Test
    public void positiveWordStringTest() {
        PositiveWord positiveWord = new PositiveWord(positiveWordAsString);
        Assertions.assertEquals("chair", positiveWord.getWordAsString());
    }

    @Test
    public void positiveWordSearchResultTest() {
        PositiveWord positiveWord = new PositiveWord(positiveWordAsString);
        positiveWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, positiveWord.getSearchResult());
    }


    @Test
    public void negativeWordPriorityTest() {
        NegativeWord negativeWord = new NegativeWord(negativeWordAsString);
        Assertions.assertEquals(3, negativeWord.getPriority());
    }

    @Test
    public void negativeWordStringTest() {
        NegativeWord negativeWord = new NegativeWord(negativeWordAsString);
        Assertions.assertEquals("negative", negativeWord.getWordAsString());
    }

    @Test
    public void negativeWordSearchResultTest() {
        NegativeWord negativeWord = new NegativeWord(negativeWordAsString);
        negativeWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, negativeWord.getSearchResult());
    }


    @Test
    public void neutralWordPriorityTest() {
        NeutralWord neutralWord = new NeutralWord(neutralWordAsString);
        Assertions.assertEquals(2, neutralWord.getPriority());
    }

    @Test
    public void neutralWordStringTest() {
        NeutralWord neutralWord = new NeutralWord(neutralWordAsString);
        Assertions.assertEquals("rider", neutralWord.getWordAsString());
    }

    @Test
    public void neutralWordSearchResultTest() {
        NeutralWord neutralWord = new NeutralWord(neutralWordAsString);
        neutralWord.setSearchResult(demoSearchResult);
        Assertions.assertEquals(demoSearchResult, neutralWord.getSearchResult());
    }
}
