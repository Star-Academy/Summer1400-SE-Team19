using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public interface IWord
    {
        public int Priority { get; }
        public string WordAsString { get; }
        public HashSet<int> SearchResults { get; set; }
    }
}