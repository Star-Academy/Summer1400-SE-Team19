using System.Collections.Generic;

namespace InvertedIndexSearcher.words
{
    public class PositiveWord : IWord
    {
        public WordType Priority => WordType.Positive;
        public string WordAsString { get; }

        public PositiveWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}