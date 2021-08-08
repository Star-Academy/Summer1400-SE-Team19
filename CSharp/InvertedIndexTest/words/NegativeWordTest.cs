using System.Collections.Generic;
using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class NegativeWordTest
    {
        private readonly IWord _negativeWord = new NegativeWord("-negative");

        [Fact]
        public void NegativeWordPriorityTest()
        {
            Assert.Equal(3, _negativeWord.Priority);
        }

        [Fact]
        public void NegativeWordAsStringTest()
        {
            Assert.Equal("negative", _negativeWord.WordAsString);
        }

        [Fact]
        public void NegativeWordSearchResultTest()
        {
            var hashSet = new HashSet<int>() {4, 5, 6};
            _negativeWord.SearchResults = hashSet;
            Assert.True(new HashSet<int>(){4, 5, 6}.SetEquals(_negativeWord.SearchResults));
        }
    }
}