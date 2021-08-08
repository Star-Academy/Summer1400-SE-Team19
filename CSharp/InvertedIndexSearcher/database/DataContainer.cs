using System.Collections.Generic;

namespace InvertedIndexSearcher.database
{
    public class DataContainer : IDataContainer<string, HashSet<int>>
    {
        private Dictionary<string, HashSet<int>> _allData;

        public DataContainer()
        {
            _allData = new Dictionary<string, HashSet<int>>();
        }

        public Dictionary<string, HashSet<int>> GetAllData()
        {
            return _allData;
        }

        public void SetAllData(Dictionary<string, HashSet<int>> allData)
        {
            _allData = allData;
        }
    }
}