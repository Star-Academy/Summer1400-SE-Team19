using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IFilterer
    {
        public HashSet<int> Filter(IWord word, HashSet<int> preResult);
    }
}