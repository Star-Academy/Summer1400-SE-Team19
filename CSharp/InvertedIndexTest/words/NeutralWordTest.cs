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
            Assert.Equal(2, (int)_neutralWord.Priority);
        }

        [Fact]
        public void NeutralWordAsStringTest()
        {
            Assert.Equal("neutral", _neutralWord.WordAsString);
        }
    }
}