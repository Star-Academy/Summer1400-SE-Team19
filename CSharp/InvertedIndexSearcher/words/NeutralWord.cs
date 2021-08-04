using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class NeutralWord : IWord
    {
        public int Priority => 2;
        public string WordAsString { get; }
        public HashSet<int> SearchResults { get; set; }

        public NeutralWord(string wordAsString)
        {
            WordAsString = wordAsString;
        }
    }
}