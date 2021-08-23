using System.Collections.Generic;
using Search.words;

namespace Search.modifiers
{
    internal class TypeChecker : ITypeChecker
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
                if (word.StartsWith("+")) PositiveWords.Add(new Word(word[1..]));
                else if (word.StartsWith("-")) NegativeWords.Add(new Word(word[1..]));
                else NeutralWords.Add(new Word(word));
            }
        }
    }
}