namespace InvertedIndexSearcher.words
{
    internal class Word : IWord
    {
        public string WordAsString { get; }

        public Word(string wordAsString)
        {
            WordAsString = wordAsString; 
        }
    }
}