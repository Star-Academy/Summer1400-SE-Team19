using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class WordTest
    {
        private readonly IWord _positiveWord = new Word("+positive");
        
        [Fact]
        public void PositiveWordAsStringTest()
        {
            Assert.Equal("positive", _positiveWord.WordAsString);
        }
    }
}