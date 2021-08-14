namespace InvertedIndexSearcher.words
{
    public class Word : IWord
    {
        public string WordAsString { get; }
        public Word(string wordAsString)
        {
            WordAsString = wordAsString;
        }
    }
}