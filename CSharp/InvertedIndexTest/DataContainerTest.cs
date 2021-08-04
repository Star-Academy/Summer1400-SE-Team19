
using System.Collections.Generic;
using InvertedIndexSearcher.database;
using Xunit;

namespace InvertedIndexTest
{
    public class DataContainerTest
    {
        private readonly DataContainer _dataContainer = new DataContainer();
        [Fact]
        public void GetAndSetTest()
        {
            var hashSet = new HashSet<int> {1, 2};
            _dataContainer.AllData = new Dictionary<string, HashSet<int>> {["test"] = hashSet};
            Assert.Equal(2, _dataContainer.AllData["test"].Count);
        }
        [Fact]
        public void GetAndSetWithRepeatedAddressTest()
        {
            var hashSet = new HashSet<int> {1, 2, 1};
            _dataContainer.AllData = new Dictionary<string, HashSet<int>> {["test"] = hashSet};
            Assert.Equal(2, _dataContainer.AllData["test"].Count);
        }
    }
    
}