using System.Collections.Generic;
using System.Linq;
using Search.database;
using Search.words;

namespace Search.modifiers
{
    internal class DataCollector : IDataCollector
    {
        private readonly ILibraryDatabase _database;

        public DataCollector(ILibraryDatabase database)
        {
            _database = database;
        }
        public IEnumerable<HashSet<string>> Collect(IEnumerable<IWord> words)
        {
            return words.Select(word => _database.WordAndAddressWrapper.Where(x => x.Word == word.WordAsString)
                    .Select(x => x.Address)
                    .ToHashSet())
                .ToList();
        }
    }
}