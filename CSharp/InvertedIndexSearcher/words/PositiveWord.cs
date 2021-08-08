namespace InvertedIndexSearcher.words
{
    public class PositiveWord : IWord
    {
        public string WordAsString { get; }

        public PositiveWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}