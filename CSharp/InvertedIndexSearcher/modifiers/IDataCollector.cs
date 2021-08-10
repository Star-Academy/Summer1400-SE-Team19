using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IDataCollector
    {
        IEnumerable<HashSet<int>> Collect(IEnumerable<IWord> words);
    }
}