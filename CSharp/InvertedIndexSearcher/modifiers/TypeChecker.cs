using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class TypeChecker : ITypeChecker
    {
        public List<IWord> PositiveWords { get; }
        public List<IWord> NeutralWords { get; }
        public List<IWord> NegativeWords { get; }

        public TypeChecker()
        {
            PositiveWords = new List<IWord>();
            NeutralWords = new List<IWord>();
            NegativeWords = new List<IWord>();
        }

        public void CheckWordsType(IEnumerable<string> words)
        {
            foreach (var word in words)
            {
                if (word.StartsWith("+")) PositiveWords.Add(new PositiveWord(word));
                else if (word.StartsWith("-")) NegativeWords.Add(new NegativeWord(word));
                else NeutralWords.Add(new NeutralWord(word));
            }
        }
    }
}