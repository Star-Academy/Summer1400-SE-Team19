using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public interface IFilterer<T>
    {
        public HashSet<T> FilterSearchResult(IEnumerable<string> searchResultOfWord, IEnumerable<T> preResult);
    }
}