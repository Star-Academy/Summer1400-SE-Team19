using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public class NeutralsWordFilterer : INeutralsWordFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord,
            IEnumerable<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            if (result.Count != 0)
                result.IntersectWith(searchResultOfWord);
            else
                result.UnionWith(searchResultOfWord);
            return result;
        }
    }
}