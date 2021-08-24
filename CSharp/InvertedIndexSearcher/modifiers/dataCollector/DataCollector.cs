using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers.dataCollector
{
    public class DataCollector : IDataCollector
    {
        private readonly IDataContainer<string, HashSet<int>> _dataContainer;

        public DataCollector(IDataContainer<string, HashSet<int>> dataContainer)
        {
            _dataContainer = dataContainer;
        }

        public List<HashSet<int>> Collect(IEnumerable<IWord> words)
        {
            var listOfSearchedResultOfWords = new List<HashSet<int>>();
            foreach (var word in words)
            {
                if (!_dataContainer.GetAllData().TryGetValue(word.WordAsString, out var result))
                    result = new HashSet<int>();

                listOfSearchedResultOfWords.Add(result);
            }

            return listOfSearchedResultOfWords;
        }
    }
}