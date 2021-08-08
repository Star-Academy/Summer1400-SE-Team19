using System.Collections.Generic;
using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class NeutralWordTest
    {
        private readonly IWord _neutralWord = new NeutralWord("neutral");

        [Fact]
        public void NeutralWordPriorityTest()
        {
            Assert.Equal(2, _neutralWord.Priority);
        }

        [Fact]
        public void NeutralWordAsStringTest()
        {
            Assert.Equal("neutral", _neutralWord.WordAsString);
        }

        [Fact]
        public void NeutralWordSearchResultTest()
        {
            var hashSet = new HashSet<int>() {1, 2};
            _neutralWord.SearchResults = hashSet;
            Assert.True(new HashSet<int>(){1, 2}.SetEquals(_neutralWord.SearchResults));
        }
    }
}