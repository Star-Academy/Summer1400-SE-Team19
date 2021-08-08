using System.Collections.Generic;
using InvertedIndexSearcher.modifiers;

namespace InvertedIndexSearcher
{
    public class Searcher
    {
        private TypeChecker _typeChecker;
        private IFilterer positiveFilterer;
        private IFilterer neutralFilterer;
        private IFilterer negativeFilterer;

        public List<int> ExtendedSearcherMethod(string searchedNote)
        {
            var separatedWords = searchedNote.Split(" ");
            _typeChecker.CheckWordsType(separatedWords);
            foreach (var positiveWord in _typeChecker.PositiveWords)
            {
                
            }
        }
    }
}