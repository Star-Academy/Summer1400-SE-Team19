package modifiers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;

@ExtendWith(MockitoExtension.class)
public class MergerTest {


    @Mock
    PositiveWord positiveWord;
    @Mock
    NegativeWord negativeWord;
    @Mock
    NeutralWord neutralWord;

    @BeforeEach
    public void init() {

        doCallRealMethod().when(positiveWord).setSearchResult(any());
        doCallRealMethod().when(negativeWord).setSearchResult(any());
        doCallRealMethod().when(neutralWord).setSearchResult(any());

        doCallRealMethod().when(positiveWord).filter(any());
        doCallRealMethod().when(negativeWord).filter(any());
        doCallRealMethod().when(neutralWord).filter(any());

        HashSet<Integer> demoResultForPositiveWord = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> demoResultForNegativeWord = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> demoResultForNeutralWord = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        positiveWord.setSearchResult(demoResultForPositiveWord);
        neutralWord.setSearchResult(demoResultForNeutralWord);
        negativeWord.setSearchResult(demoResultForNegativeWord);

    }

    @Test
    public void mergeOneWordInputTest() {
        Merger simpleMerge = new Merger();
        HashSet<Integer> resultForPositive = simpleMerge.mergeSearchResult(new ArrayList<>(Collections.singletonList(positiveWord)));
        Assertions.assertEquals(3, resultForPositive.size());

        HashSet<Integer> resultForNegative = simpleMerge.mergeSearchResult(new ArrayList<>(Collections.singletonList(negativeWord)));
        Assertions.assertEquals(resultForNegative.size(), 0);

        HashSet<Integer> resultForNeutral = simpleMerge.mergeSearchResult(new ArrayList<>(Collections.singletonList(neutralWord)));
        Assertions.assertEquals(resultForNeutral.size(), 5);

    }

    @Test
    public void mergeRepeatedWordsInputTest() {
        Merger repeatedWordMergerOne = new Merger();
        HashSet<Integer> resultForPositive =
                repeatedWordMergerOne.mergeSearchResult(new ArrayList<>(Arrays.asList(positiveWord, positiveWord)));
        Assertions.assertEquals(3, resultForPositive.size());

        Merger repeatedWordMergerTwo = new Merger();
        HashSet<Integer> resultForNegative =
                repeatedWordMergerTwo.mergeSearchResult(new ArrayList<>(Arrays.asList(negativeWord, negativeWord)));
        Assertions.assertEquals(0, resultForNegative.size());

        Merger repeatedWordMergerThree = new Merger();
        HashSet<Integer> resultForNeutral =
                repeatedWordMergerThree.mergeSearchResult(new ArrayList<>(Arrays.asList(neutralWord, neutralWord)));
        Assertions.assertEquals(5, resultForNeutral.size());
    }

    @Test
    public void mergeTwoDifferentTypeWordsTest() {
        Merger twoDifferentTypeOfWordsMergerOne = new Merger();
        HashSet<Integer> resultForPositiveAndNegative =
                twoDifferentTypeOfWordsMergerOne.mergeSearchResult(new ArrayList<>(Arrays.asList(positiveWord, negativeWord)));
        Assertions.assertEquals(0, resultForPositiveAndNegative.size());

        Merger twoDifferentTypeOfWordsMergerTwo = new Merger();
        HashSet<Integer> resultForNegativeAndNeutral =
                twoDifferentTypeOfWordsMergerTwo.mergeSearchResult(new ArrayList<>(Arrays.asList(neutralWord, negativeWord)));
        Assertions.assertEquals(1, resultForNegativeAndNeutral.size());

        Merger twoDifferentTypeOfWordsMergerThree = new Merger();
        HashSet<Integer> resultForNeutralAndPositive =
                twoDifferentTypeOfWordsMergerThree.mergeSearchResult(new ArrayList<>(Arrays.asList(positiveWord, neutralWord)));
        Assertions.assertEquals(3, resultForNeutralAndPositive.size());
    }


    @Test
    public void mergeThreeDifferentTypeWordsTest() {

        Merger threeDifferentTypeOfWordsMergerTwo = new Merger();
        HashSet<Integer> resultForNegativeAndNeutral =
                threeDifferentTypeOfWordsMergerTwo.mergeSearchResult(
                        new ArrayList<>(Arrays.asList(positiveWord, neutralWord, negativeWord)));

        Assertions.assertEquals(0, resultForNegativeAndNeutral.size());

    }
}
