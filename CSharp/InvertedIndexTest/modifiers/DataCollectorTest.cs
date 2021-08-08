using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.words;
using NSubstitute;
using NSubstitute.ReceivedExtensions;
using Xunit;

namespace InvertedIndexTest.modifiers
{
    public class DataCollectorTest
    {
        private readonly IWord _word;
        private readonly IDataContainer<string, HashSet<int>> _dataContainer;

        public DataCollectorTest()
        {
            _dataContainer = Substitute.For<IDataContainer<string, HashSet<int>>>();
            _word = Substitute.For<IWord>();
        }


        [Fact]
        public void SearchAvailableWord()
        {
            var demoSearchInfoForWord = new HashSet<int>() {1, 2, 3, 4};
            var demoDatabaseInfo = new Dictionary<string, HashSet<int>> {{"test", demoSearchInfoForWord}};
            _dataContainer.GetAllData().Returns(demoDatabaseInfo);

            _word.WordAsString.Returns("test");
            var searcher = new DataCollector(_dataContainer);
            var result = searcher.Collect(new List<IWord>()
            {
                _word
            });
            Assert.Equal(demoSearchInfoForWord, result[_word]);
        }

        [Fact]
        public void SearchNotAvailableWord()
        {
            _dataContainer.GetAllData().Returns(new Dictionary<string, HashSet<int>>());
            _word.WordAsString.Returns("negative");
            var searcher = new DataCollector(_dataContainer);
            var result = searcher.Collect(new List<IWord>()
            {
                _word
            });
            Assert.Empty(result[_word]);
        }
    }
}