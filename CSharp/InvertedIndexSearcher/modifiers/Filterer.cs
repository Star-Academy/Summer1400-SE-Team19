using System;
using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class Filterer : IFilterer
    {
        public HashSet<int> FilterSearchResult(WordType type, IEnumerable<int> searchResultOfWord,
            IEnumerable<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            switch (type)
            {
                case WordType.Positive:
                    result.UnionWith(searchResultOfWord);
                    break;
                case WordType.Neutral:
                    result.ExceptWith(searchResultOfWord);
                    break;
                case WordType.Negative:
                    result.IntersectWith(searchResultOfWord);
                    break;
                default:
                    throw new ArgumentOutOfRangeException(nameof(type), type, "system not working properly");
            }

            return result;
        }
    }
}