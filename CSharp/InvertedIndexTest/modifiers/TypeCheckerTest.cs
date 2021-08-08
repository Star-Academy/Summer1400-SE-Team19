using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.words;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class TypeCheckerTest
    {
        [Fact]
        public void RecognizePositiveWordTest()
        {
            const string positiveWordAsString = "+positive";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {positiveWordAsString});
            Assert.True(checker.PositiveWords[0].GetType() == typeof(PositiveWord));
        }

        [Fact]
        public void RecognizeNegativeWordTest()
        {
            const string negativeWordAsString = "-negative";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {negativeWordAsString});
            Assert.True(checker.negativeWords[0].GetType() == typeof(NegativeWord));
        }

        [Fact]
        public void RecognizeNeutralWordTest()
        {
            const string neutralWordAsString = "neutral";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {neutralWordAsString});
            Assert.True(checker.NeutralWords[0].GetType() == typeof(NeutralWord));
        }
    }
}