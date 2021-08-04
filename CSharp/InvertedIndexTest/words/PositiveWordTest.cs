using System.Collections.Generic;
using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class PositiveWordTest
    {
        private readonly IWord _positiveWord = new PositiveWord("+positive");

        [Fact]
        public void PositiveWordPriorityTest()
        {
            Assert.Equal(1, _positiveWord.Priority);
        }

        [Fact]
        public void PositiveWordAsStringTest()
        {
            Assert.Equal("positive", _positiveWord.WordAsString);
        }

        [Fact]
        public void PositiveWordSearchResultTest()
        {
            var hashSet = new HashSet<int>() {1, 2, 3};
            _positiveWord.SearchResults = hashSet;
            Assert.True(new HashSet<int>(){1, 2, 3}.SetEquals(_positiveWord.SearchResults));
        }
    }
}