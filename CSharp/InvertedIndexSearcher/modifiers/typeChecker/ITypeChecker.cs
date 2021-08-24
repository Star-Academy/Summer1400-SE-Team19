using System.Collections.Generic;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers.typeChecker
{
    public interface ITypeChecker

    {
        public List<IWord> PositiveWords { get; }
        public List<IWord> NeutralWords { get; }
        public List<IWord> NegativeWords { get; }
        void CheckWordsType(IEnumerable<string> words);
    }
}