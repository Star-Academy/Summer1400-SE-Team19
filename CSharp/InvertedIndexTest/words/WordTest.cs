using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class WordTest
    {
        private readonly IWord _neutralWord = new Word("neutral");

        [Fact]
        public void NeutralWordAsStringTest()
        {
            Assert.Equal("neutral", _neutralWord.WordAsString);
        }
    }
}