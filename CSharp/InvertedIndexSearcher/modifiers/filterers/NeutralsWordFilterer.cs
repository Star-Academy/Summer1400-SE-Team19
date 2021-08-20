using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public class NeutralsWordFilterer : INeutralsWordFilterer
    {
        public HashSet<string> FilterSearchResult(HashSet<string> searchResultOfWord,
            IEnumerable<string> preResult)
        {
            var result = new HashSet<string>(preResult);
            if (result.Count != 0)
                result.IntersectWith(searchResultOfWord);
            else
                result.UnionWith(searchResultOfWord);
            return result;
        }
    }
}