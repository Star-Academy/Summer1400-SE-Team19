using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.LibraryConfig;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;

namespace InvertedIndexSearcher.Searcher
{
    public class Searcher : ISearcher
    {
        private readonly ITypeChecker _typeChecker;
        private readonly IFilterer<string> _positiveFilterer;
        private readonly IFilterer<string> _neutralsFilterer;
        private readonly IFilterer<string> _negativeFilterer;
        private readonly IDataCollector _collector;

        public Searcher(ServiceResolver serviceResolver,
            ITypeChecker typeChecker, IDataCollector collector)
        {
            _positiveFilterer =serviceResolver("positive");
            _neutralsFilterer = serviceResolver("neutral");
            _negativeFilterer = serviceResolver("negative");
            _typeChecker = typeChecker;
            _collector = collector;
        }

        public IEnumerable<string> Search(string searchedNote)
        {
            var separatedWords = searchedNote.Split(" ");
            _typeChecker.CheckWordsType(separatedWords);
            var resultOfPositives = _collector.Collect(_typeChecker.PositiveWords);
            var resultOfNeutrals = _collector.Collect(_typeChecker.NeutralWords);
            var resultOfNegatives = _collector.Collect(_typeChecker.NegativeWords);

            return MergeResults(resultOfPositives, resultOfNeutrals, resultOfNegatives);
        }

        private IEnumerable<string> MergeResults(IEnumerable<HashSet<string>> resultOfPositives,
            IEnumerable<HashSet<string>> resultOfNeutrals,
            IEnumerable<HashSet<string>> resultOfNegatives)
        {
            var searchResult = new HashSet<string>();
            searchResult = resultOfPositives.Aggregate(searchResult, (current, resultOfPositive)
                => _positiveFilterer.FilterSearchResult(resultOfPositive, current));

            searchResult = resultOfNeutrals.Aggregate(searchResult, (current, resultOfNeutral)
                => _neutralsFilterer.FilterSearchResult(resultOfNeutral, current));

            return resultOfNegatives.Aggregate(searchResult, (current, resultOfNegative)
                => _negativeFilterer.FilterSearchResult(resultOfNegative, current));
        }
    }
}