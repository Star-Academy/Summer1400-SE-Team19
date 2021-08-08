using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public class NeutralWordFilterer : IFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord,
            IEnumerable<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            result.IntersectWith(searchResultOfWord);
            return result;
        }
    }
}