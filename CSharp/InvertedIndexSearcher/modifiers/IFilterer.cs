using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public interface IFilterer
    {
        public HashSet<int> FilterSearchResult(WordType type, IEnumerable<int> searchResultOfWord, IEnumerable<int> preResult);
    }
}