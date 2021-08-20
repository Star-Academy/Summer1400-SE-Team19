using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class DataCollector : IDataCollector
    {
        private readonly Database _database;

        public DataCollector(Database database)
        {
            _database = database;
        }
        public IEnumerable<HashSet<string>> Collect(IEnumerable<IWord> words)
        {
            var listOfSearchedResultOfWords = new List<HashSet<string>>();
            foreach (var word in words)
            {
                var resultOfSearch = _database.WordAndAddressWrapper
                    .Where(x => x.Word == word.WordAsString)
                    .Select(x => x.Address).ToHashSet();
                listOfSearchedResultOfWords.Add(resultOfSearch);
            }

            return listOfSearchedResultOfWords;
        }
    }
}