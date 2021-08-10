using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class DataCollector : IDataCollector
    {
        public IEnumerable<HashSet<int>> Collect(IEnumerable<IWord> words)
        {
            var listOfSearchedResultOfWords = new List<HashSet<int>>();
            foreach (var word in words)
            {
                using var context = new Database();
                var resultOfSearch = context.WordAndAddressWrapper
                    .Where(x => x.Word == word.WordAsString)
                    .Select(x => x.Address).ToHashSet();
                listOfSearchedResultOfWords.Add(resultOfSearch);
            }

            return listOfSearchedResultOfWords;
        }
    }
}