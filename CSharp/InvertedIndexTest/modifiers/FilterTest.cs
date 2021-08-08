using System.Collections.Generic;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.words;
using NSubstitute;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class FilterTest
    {
        private readonly Filterer _filterer = new Filterer();

        [Fact]
        public void PositiveWordFilterTest()
        {
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3, 4};
            var results = _filterer.FilterSearchResult(WordType.Positive, demoSearchResultForWord,
                new HashSet<int>() {8, 9, 1});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4, 8, 9}));
        }

        [Fact]
        public void NegativeWordFilterTest()
        {
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3};
            var results = _filterer.FilterSearchResult(WordType.Negative, demoSearchResultForWord,
                new HashSet<int>() {1, 2, 3, 4});
            Assert.True(results.SetEquals(new HashSet<int>() {4}));
        }

        [Fact]
        public void NeutralWordFilterTest()
        {
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3, 4, 6};
            var results = _filterer.FilterSearchResult(WordType.Neutral, demoSearchResultForWord,
                new HashSet<int>() {1, 2, 3, 4, 5});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4}));
        }
    }
}