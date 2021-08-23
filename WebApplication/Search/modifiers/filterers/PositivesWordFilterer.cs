using System.Collections.Generic;

namespace Search.modifiers.filterers
{
    public class PositivesWordFilterer : IFilterer<string>
    {
        public HashSet<string> FilterSearchResult(IEnumerable<string> searchResultOfWord,
            IEnumerable<string> preResult)
        {
            var result = new HashSet<string>(preResult);
            result.UnionWith(searchResultOfWord);
            return result;
        }
    }
}