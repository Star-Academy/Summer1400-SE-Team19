using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class Filterer : IFilterer
    {
        public HashSet<int> Filter(IWord word, HashSet<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            switch (word.Priority)
            {
                case 1:
                    result.UnionWith(word.SearchResults);
                    break;
                case 2:
                    result.ExceptWith(word.SearchResults);
                    break;
                case 3:
                    result.IntersectWith(word.SearchResults);
                    break;
            }

            return result;
        }
    }
}