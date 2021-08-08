using System.Collections.Generic;
using System.Linq;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class TypeCheckerTest
    {
        private readonly TypeChecker _typeChecker = new();

        [Fact]
        public void PositiveWordTypeTest()
        {
            const string wordAsString = "+positive";
            var word = _typeChecker.GetWordInstance(wordAsString);
            Assert.True(word is PositiveWord);
        }

        [Fact]
        public void NegativeWordTypeTest()
        {
            const string wordAsString = "-negative";
            var word = _typeChecker.GetWordInstance(wordAsString);
            Assert.True(word is NegativeWord);
        }

        [Fact]
        public void NeutralWordTypeTest()
        {
            const string wordAsString = "neutral";
            var word = _typeChecker.GetWordInstance(wordAsString);
            Assert.True(word is NeutralWord);
        }

        [Fact]
        public void SeparateWordsTest()
        {
            var wordsAsString = new List<string>() {"-negative", "neutral", "+positive"};
            var words = _typeChecker.GetSeparatedWords(wordsAsString);
            Assert.Equal(3, words.Count);
        }

        [Fact]
        public void SortWordsTest()
        {
            var negativeWord = _typeChecker.GetWordInstance("-negative");
            var neutralWord = _typeChecker.GetWordInstance("neutral");
            var positiveWord = _typeChecker.GetWordInstance("+positive");
            var sortedWords = _typeChecker.SortWords(new List<IWord>() {negativeWord, neutralWord, positiveWord});
            var expectedSortedWords = new List<IWord>() {positiveWord, neutralWord, negativeWord};
            Assert.True(sortedWords.SequenceEqual(expectedSortedWords));
        }

        [Fact]
        public void OperateOnWordsTest()
        {
            var wordsAsString = new List<string>() {"+pos", "-neg", "neu"};
            var expectedResult = new List<string>() {"pos", "neu", "neg"};
            var result = _typeChecker.OperateOnWords(wordsAsString).Select(w => w.WordAsString);
            Assert.True(result.SequenceEqual(expectedResult));
        }
    }
}