using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.DataProviders.DatabaseUpdater
{
    public class DataBaseWordDataUpdater : IDataBaseUpdater<string>
    {
        private readonly Database _database;

        public DataBaseWordDataUpdater(Database database)
        {
            _database = database;
        }

        public void AddData(string fileName, IEnumerable<string> tokens)
        {
            foreach (var content in tokens)
            {
                var wordAndAddressWrapper = new WordAndAddressWrapper()
                {
                    Word = content,
                    Address = fileName
                };
                _database.WordAndAddressWrapper.Add(wordAndAddressWrapper);
            }

            _database.SaveChanges();
        }
    }
}