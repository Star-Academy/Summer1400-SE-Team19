using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class PositiveWord : IWord
    {
        public int Priority => 1;
        public string WordAsString { get; }
        public HashSet<int> SearchResults { get; set; }

        public PositiveWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}