using System.Collections.Generic;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterer;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class FilterTest
    {
        [Fact]
        public void PositiveWordFilterTest()
        {
            var positivesWordFilterer = new PositivesWordFilterer();
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3, 4};
            var results = positivesWordFilterer.FilterSearchResult(demoSearchResultForWord,
                new HashSet<int>() {8, 9, 1});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4, 8, 9}));
        }

        [Fact]
        public void NegativeWordFilterTest()
        {
            var negativesWordFilterer = new NegativesWordFilterer();
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3};
            var results = negativesWordFilterer.FilterSearchResult(demoSearchResultForWord,
                new HashSet<int>() {1, 2, 3, 4});
            Assert.True(results.SetEquals(new HashSet<int>() {4}));
        }

        [Fact]
        public void NeutralWordFilterTest()
        {
            var neutralWordFilterer = new NeutralsWordFilterer();
            var demoSearchResultForWord = new HashSet<int>() {1, 2, 3, 4, 6};
            var results = neutralWordFilterer.FilterSearchResult(demoSearchResultForWord,
                new HashSet<int>() {1, 2, 3, 4, 5});
            Assert.True(results.SetEquals(new HashSet<int>() {1, 2, 3, 4}));
        }
    }
}