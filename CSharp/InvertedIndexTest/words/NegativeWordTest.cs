using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.words
{
    public class NegativeWordTest
    {
        private readonly IWord _negativeWord = new NegativeWord("-negative");
        
        [Fact]
        public void NegativeWordAsStringTest()
        {
            Assert.Equal("negative", _negativeWord.WordAsString);
        }
    }
}