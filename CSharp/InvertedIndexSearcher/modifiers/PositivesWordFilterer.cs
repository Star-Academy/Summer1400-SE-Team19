using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public class PositivesWordFilterer : IFilterer
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