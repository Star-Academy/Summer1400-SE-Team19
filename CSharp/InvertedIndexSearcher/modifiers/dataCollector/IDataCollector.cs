using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers.dataCollector
{
    public interface IDataCollector
    {
        List<HashSet<int>> Collect(IEnumerable<IWord> words);
    }
}