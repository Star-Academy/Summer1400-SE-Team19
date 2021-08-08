﻿using System.Collections.Generic;

namespace InvertedIndexSearcher.modifiers
{
    public class NegativesWordFilterer : IFilterer
    {
        public HashSet<int> FilterSearchResult(IEnumerable<int> searchResultOfWord,
            IEnumerable<int> preResult)
        {
            var result = new HashSet<int>(preResult);
            result.ExceptWith(searchResultOfWord);
            return result;
        }
    }
}