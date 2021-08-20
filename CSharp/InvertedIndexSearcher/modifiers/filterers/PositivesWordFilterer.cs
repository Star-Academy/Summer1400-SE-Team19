using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public class PositivesWordFilterer : IPositivesWordFilterer
    {
        public HashSet<string> FilterSearchResult(HashSet<string> searchResultOfWord,
            IEnumerable<string> preResult)
        {
            var result = new HashSet<string>(preResult);
            result.UnionWith(searchResultOfWord);
            return result;
        }
    }
}