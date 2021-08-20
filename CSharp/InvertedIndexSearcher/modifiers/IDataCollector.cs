using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IDataCollector
    {
        IEnumerable<HashSet<string>> Collect(IEnumerable<IWord> words);
    }
}