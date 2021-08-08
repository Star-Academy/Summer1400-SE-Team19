﻿using System;
using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class Searcher
    {
        private readonly IDataContainer<string, HashSet<int>> _dataContainer;

        public Searcher(IDataContainer<string, HashSet<int>> dataContainer)
        {
            _dataContainer = dataContainer;
        }

        public Dictionary<IWord, HashSet<int>> Search(IEnumerable<IWord> words)
        {
            var wordAndSearchResultsDictionary = new Dictionary<IWord, HashSet<int>>();
            foreach (var word in words)
            {
                if (!_dataContainer.GetAllData().TryGetValue(word.WordAsString, out var result))
                    result = new HashSet<int>();

                wordAndSearchResultsDictionary.Add(word, result);
            }

            return wordAndSearchResultsDictionary;
        }
    }
}