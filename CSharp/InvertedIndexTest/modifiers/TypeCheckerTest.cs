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
            Assert.Equal("positive", checker.PositiveWords[0].WordAsString);
        }

        [Fact]
        public void RecognizeNegativeWordTest()
        {
            const string negativeWordAsString = "-negative";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {negativeWordAsString});
            Assert.Equal("negative",checker.NegativeWords[0].WordAsString);
        }

        [Fact]
        public void RecognizeNeutralWordTest()
        {
            const string neutralWordAsString = "neutral";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {neutralWordAsString});
            Assert.True(checker.NeutralWords[0].GetType() == typeof(Word));
        }
    }
}