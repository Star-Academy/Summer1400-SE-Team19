using System.Collections.Generic;
using Search.words;

namespace Search.modifiers
{
    public interface IDataCollector
    {
        IEnumerable<HashSet<string>> Collect(IEnumerable<IWord> words);
        
    }
}