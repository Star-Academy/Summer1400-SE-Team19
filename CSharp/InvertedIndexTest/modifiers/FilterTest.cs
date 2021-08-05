using System.Collections.Generic;
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
            word.SearchResults.Returns(new HashSet<int>() {1, 2, 3, 4});
            word.Priority.Returns(1);
            var results = _filterer.Filter(word, new HashSet<int>() {8, 9, 1});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4, 8, 9}));
        }

        [Fact]
        public void NegativeWordFilterTest()
        {
            var word = Substitute.For<IWord>();
            word.SearchResults.Returns(new HashSet<int>() {1, 2, 3});
            word.Priority.Returns(2);
            var results = _filterer.Filter(word, new HashSet<int>() {1, 2, 3, 4});
            Assert.True(results.SetEquals(new HashSet<int>() {4}));
        }

        [Fact]
        public void NeutralWordFilterTest()
        {
            var word = Substitute.For<IWord>();
            word.SearchResults.Returns(new HashSet<int>() {1, 2, 3, 4 , 7});
            word.Priority.Returns(3);
            var results = _filterer.Filter(word, new HashSet<int>() {1, 2, 3, 4, 5, 6});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4}));
        }
    }
}