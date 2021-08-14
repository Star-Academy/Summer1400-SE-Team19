using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public interface IFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord, IEnumerable<int> preResult);
    }
}