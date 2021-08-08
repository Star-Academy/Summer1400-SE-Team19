using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IDataCollector
    {
        List<HashSet<int>> Collect(IEnumerable<IWord> words);
    }
}