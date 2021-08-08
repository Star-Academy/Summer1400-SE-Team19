using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class NeutralWord : IWord
    {
        public WordType Priority => WordType.Neutral;
        public string WordAsString { get; }
        public NeutralWord(string wordAsString)
        {
            WordAsString = wordAsString;
        }
    }
}