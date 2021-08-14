package modifiers;


import customizedassertions.CollectionsComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import words.NegativeWord;
import words.NeutralWord;
import words.PositiveWord;
import words.Word;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.mockito.Mockito.when;

;

@ExtendWith(MockitoExtension.class)
public class FilterTest {

    private static CollectionsComparator collectionsComparator;

    @Mock
    Word positiveWord;
    @Mock
    Word neutralWord;
    @Mock
    Word negativeWord;

    @BeforeAll
    public static void init() {
        collectionsComparator = new CollectionsComparator();
    }



    @Test
    public void filterPositiveWordTest() {
        HashSet<Integer> demoResultForPositiveWord = new HashSet<>(Arrays.asList(1, 2, 3));
        when(positiveWord.getSearchResult()).thenReturn(demoResultForPositiveWord);
        when(positiveWord.getPriority()).thenReturn(1);
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 5));
        modifiers.abstraction.Filter filter = new Filter();
        filter.filter(positiveWord, demoResult);
        Assertions.assertTrue(collectionsComparator.areHashSetsEqual(demoResult, new HashSet<>(Arrays.asList(1, 2, 3, 5))));
    }

    @Test
    public void filterNeutralWordTest() {
        HashSet<Integer> demoResultForNeutralWord = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        when(neutralWord.getSearchResult()).thenReturn(demoResultForNeutralWord);
        when(neutralWord.getPriority()).thenReturn(2);
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 5, 6));
        modifiers.abstraction.Filter filter = new Filter();
        filter.filter(neutralWord, demoResult);
        Assertions.assertTrue(collectionsComparator.areHashSetsEqual(demoResult, new HashSet<>(Arrays.asList(1, 2, 5))));
    }

    @Test
    public void filterNegativeWordTest() {
        HashSet<Integer> demoResultForNegativeWord = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        when(negativeWord.getSearchResult()).thenReturn(demoResultForNegativeWord);
        when(negativeWord.getPriority()).thenReturn(3);
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 5));
        modifiers.abstraction.Filter filter = new Filter();
        filter.filter(negativeWord, demoResult);
        Assertions.assertTrue(collectionsComparator.areHashSetsEqual(demoResult, new HashSet<>(Collections.singletonList(5))));
    }


}