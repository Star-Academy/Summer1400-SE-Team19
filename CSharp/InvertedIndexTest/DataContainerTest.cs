using System.Collections.Generic;
using InvertedIndexSearcher.database;
using Xunit;

namespace InvertedIndexTest
{
    public class DataContainerTest
    {
        private readonly DataContainer _dataContainer = new();

        [Fact]
        public void GetAndSetTest()
        {
            var hashSet = new HashSet<int> {1, 2};
            _dataContainer.SetAllData(new Dictionary<string, HashSet<int>> {["test"] = hashSet});
            Assert.Equal(2, _dataContainer.GetAllData()["test"].Count);
        }

        [Fact]
        public void GetAndSetWithRepeatedAddressTest()
        {
            var hashSet = new HashSet<int> {1, 2, 1};
            _dataContainer.SetAllData(new Dictionary<string, HashSet<int>> {["test"] = hashSet});
            Assert.Equal(2, _dataContainer.GetAllData()["test"].Count);
        }
    }
}