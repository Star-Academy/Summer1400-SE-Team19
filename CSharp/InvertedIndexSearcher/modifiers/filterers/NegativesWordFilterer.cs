using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public class NegativesWordFilterer : INegativesWordFilterer
    {
        public HashSet<string> FilterSearchResult(IEnumerable<string> searchResultOfWord,
            IEnumerable<string> preResult)
        {
            var result = new HashSet<string>(preResult);
            result.ExceptWith(searchResultOfWord);
            return result;
        }
    }
}