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
            Assert.True(checker.PositiveWords[0].GetType() == typeof(Word));
        }

        [Fact]
        public void RecognizeNegativeWordTest()
        {
            const string negativeWordAsString = "-negative";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {negativeWordAsString});
            Assert.False(checker.NegativeWords[0].WordAsString == "-negative");
        }

        [Fact]
        public void RecognizeNeutralWordTest()
        {
            const string neutralWordAsString = "neutral";
            var checker = new TypeChecker();
            checker.CheckWordsType(new[] {neutralWordAsString});
            Assert.Equal("neutral", checker.NeutralWords[0].WordAsString );
        }
    }
}