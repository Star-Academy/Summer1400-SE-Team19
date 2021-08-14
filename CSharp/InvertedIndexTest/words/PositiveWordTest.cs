using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class PositiveWordTest
    {
        private readonly IWord _positiveWord = new PositiveWord("+positive");
        
        [Fact]
        public void PositiveWordAsStringTest()
        {
            Assert.Equal("positive", _positiveWord.WordAsString);
        }
    }
}