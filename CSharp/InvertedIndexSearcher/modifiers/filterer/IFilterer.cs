using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterer
{
    public interface IFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord, IEnumerable<int> preResult);
    }
}