namespace InvertedIndexSearcher.words
{
    public class NegativeWord : IWord
    {
        public string WordAsString { get; }

        public NegativeWord(string wordAsString)
        {
            WordAsString = wordAsString[1..];
        }
    }
}