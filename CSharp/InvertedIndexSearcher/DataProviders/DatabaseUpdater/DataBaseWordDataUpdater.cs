using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;

namespace InvertedIndexSearcher.DataProviders.DatabaseUpdater
{
    internal class DataBaseWordDataUpdater : IDataBaseUpdater<string>
    {
        private readonly ILibraryDatabase _database;

        public DataBaseWordDataUpdater(ILibraryDatabase database)
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

            var unused = _database.SaveChanges();
            // this method will be overwrite by EF core classes//
            // => the return value is the number of entity 
        }
    }
}