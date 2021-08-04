using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class NegativeWord : IWord
    {
        public int Priority => 3;
        public string WordAsString { get; }
        public HashSet<int> SearchResults { get; set; }

        public NegativeWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}