using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class NegativeWord : IWord
    {
        public WordType Priority => WordType.Positive;
        public string WordAsString { get; }

        public NegativeWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}