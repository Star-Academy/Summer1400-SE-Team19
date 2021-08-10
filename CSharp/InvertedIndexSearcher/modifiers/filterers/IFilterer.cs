using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public interface IFilterer<T>
    {
        public HashSet<T> FilterSearchResult(IEnumerable<T> searchResultOfWord, IEnumerable<T> preResult);
    }
}