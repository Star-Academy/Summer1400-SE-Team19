using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;

namespace InvertedIndexSearcher
{
    public class Searcher : ISearcher
    {
        private readonly ITypeChecker _typeChecker;
        private readonly IPositivesWordFilterer _positiveFilterer;
        private readonly INeutralsWordFilterer _neutralsFilterer;
        private readonly INegativesWordFilterer _negativeFilterer;
        private readonly IDataCollector _collector;

        public Searcher(IPositivesWordFilterer positiveFilterer, 
            INeutralsWordFilterer neutralsFilterer,
            INegativesWordFilterer negativeFilterer,
            ITypeChecker typeChecker, IDataCollector collector)
        {
            _positiveFilterer =positiveFilterer;
            _neutralsFilterer = neutralsFilterer;
            _negativeFilterer = negativeFilterer;
            _typeChecker = typeChecker;
            _collector = collector;
        }

        public IEnumerable<int> Search(string searchedNote)
        {
            var separatedWords = searchedNote.Split(" ");
            _typeChecker.CheckWordsType(separatedWords);
            var resultOfPositives = _collector.Collect(_typeChecker.PositiveWords);
            var resultOfNeutrals = _collector.Collect(_typeChecker.NeutralWords);
            var resultOfNegatives = _collector.Collect(_typeChecker.NegativeWords);

            return MergeResults(resultOfPositives, resultOfNeutrals, resultOfNegatives);
        }

        private IEnumerable<int> MergeResults(IEnumerable<HashSet<int>> resultOfPositives,
            IEnumerable<HashSet<int>> resultOfNeutrals,
            IEnumerable<HashSet<int>> resultOfNegatives)
        {
            var searchResult = new HashSet<int>();
            searchResult = resultOfPositives.Aggregate(searchResult, (current, resultOfPositive)
                => _positiveFilterer.FilterSearchResult(resultOfPositive, current));

            searchResult = resultOfNeutrals.Aggregate(searchResult, (current, resultOfNeutral)
                => _neutralsFilterer.FilterSearchResult(resultOfNeutral, current));

            return resultOfNegatives.Aggregate(searchResult, (current, resultOfNegative)
                => _negativeFilterer.FilterSearchResult(resultOfNegative, current));
        }
    }
}