using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers.filterers
{
    public class PositivesWordFilterer : IPositivesWordFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord,
            IEnumerable<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            result.UnionWith(searchResultOfWord);
            return result;
        }
    }
}