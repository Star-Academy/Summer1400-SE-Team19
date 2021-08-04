using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.words;
using NSubstitute;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class FilterTest
    {
        private Filterer _filterer = new Filterer();

        [Fact]
        public void PositiveWordFilterTest()
        {
            
            var word = Substitute.For<IWord>();
        }
    }
}