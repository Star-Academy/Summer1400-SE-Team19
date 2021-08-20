using System.Collections.Generic;

namespace InvertedIndexSearcher.DataProviders.DatabaseUpdater
{
    public interface IDataBaseUpdater<in T>
    {
        public void AddData(string fileName, IEnumerable<T> content);
    }
}