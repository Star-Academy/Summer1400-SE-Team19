using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class TypeChecker
    {
        public List<IWord> PositiveWords { get; }
        public List<IWord> NeutralWords { get; }
        public List<IWord> negativeWords { get; }

        public TypeChecker()
        {
            PositiveWords = new List<IWord>();
            NeutralWords = new List<IWord>();
            negativeWords = new List<IWord>();
        }

        public void CheckWordsType(IEnumerable<string> words)
        {
            foreach (var word in words)
            {
                if (word.StartsWith("+")) PositiveWords.Add(new PositiveWord(word));
                else if (word.StartsWith("-")) negativeWords.Add(new NegativeWord(word));
                else NeutralWords.Add(new NeutralWord(word));
            }
        }
    }
}