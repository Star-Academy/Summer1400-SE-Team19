using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public class NeutralsWordFilterer : INeutralsWordFilterer
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