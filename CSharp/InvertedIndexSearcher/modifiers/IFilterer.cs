using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IFilterer
    {
        public void Filter(IWord word, HashSet<int> result);
    }
}