using System.Collections.Generic;

namespace InvertedIndexSearcher.database
{
    public interface IDataContainer<T1, T2>
    {
        Dictionary<T1, T2> GetAllData();
        void SetAllData(Dictionary<T1, T2> allData);
    }
}