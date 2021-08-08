using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.modifiers
{
    public class TypeChecker
    {
        public List<IWord> OperateOnWords(List<string> wordsAsString)
        {
            return SortWords(GetSeparatedWords(wordsAsString));
        }
        
        public List<IWord> GetSeparatedWords(List<string> wordsAsString)
        {
            return wordsAsString.Select(GetWordInstance).ToList();
        }

        public IWord GetWordInstance(string wordAsString)
        {
            if (wordAsString.StartsWith("+")) return new PositiveWord(wordAsString);
            if (wordAsString.StartsWith("-")) return new NegativeWord(wordAsString);
            return new NeutralWord(wordAsString);
        }

        public List<IWord> SortWords(List<IWord> words)
        {
            return words.OrderBy(x => x.Priority).ToList();
        }
    }
}