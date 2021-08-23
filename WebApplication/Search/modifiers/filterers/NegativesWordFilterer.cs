using System.Collections.Generic;

namespace Search.modifiers.filterers
{
    public class NegativesWordFilterer : IFilterer<string>
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