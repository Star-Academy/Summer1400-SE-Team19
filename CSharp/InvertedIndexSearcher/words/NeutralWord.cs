namespace InvertedIndexSearcher.words
{
    public class NeutralWord : IWord
    {
        public string WordAsString { get; }
        public NeutralWord(string wordAsString)
        {
            WordAsString = wordAsString;
        }
    }
}