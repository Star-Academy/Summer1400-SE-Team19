using System.Collections.Generic;

namespace Search.modifiers.filterers
{
    public class NeutralsWordFilterer :  IFilterer<string>
    {
        public HashSet<string> FilterSearchResult(IEnumerable<string> searchResultOfWord,
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