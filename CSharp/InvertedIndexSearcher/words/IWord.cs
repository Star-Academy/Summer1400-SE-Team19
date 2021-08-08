using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public interface IWord
    {
        public WordType Priority { get; }
        public string WordAsString { get; }
    }
}