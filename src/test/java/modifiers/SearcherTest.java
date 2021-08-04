package modifiers;

import database.DataContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import words.PositiveWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearcherTest {

    @Mock
    DataContainer dataContainer;
    @Mock
    PositiveWord sampleWord;

    private HashSet<Integer> results;

    @Test
    void searchNotNullTest() {
        HashSet<Integer> demoResult = new HashSet<>(Arrays.asList(1, 2, 3));
        when(dataContainer.getFilesNameWithSearchedWord("test")).thenReturn(demoResult);
        when(sampleWord.getWordAsString()).thenReturn("test");
        doAnswer((invocation -> results = invocation.getArgument(0))).when(sampleWord).setSearchResult(any());
        Searcher searcher = new Searcher();
        searcher.search(new ArrayList<>(Collections.singletonList(sampleWord)));
        Assertions.assertEquals(results.size(), 3);
    }

    @Test
    void searcherNullTest() {
        when(dataContainer.getFilesNameWithSearchedWord("test")).thenReturn(null);
        when(sampleWord.getWordAsString()).thenReturn("test");
        doAnswer((invocation -> results = invocation.getArgument(0))).when(sampleWord).setSearchResult(any());
        Searcher searcher = new Searcher();
        searcher.search(new ArrayList<>(Collections.singletonList(sampleWord)));
        Assertions.assertEquals(results.size(), 0);
    }
}