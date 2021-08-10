using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace InvertedIndexSearcher.database.dataproviders
{
    public class DefaultDataProvider : IDataProvider
    {
        private const string Directory = "../../../../InvertedIndexSearcher/resources/SampleEnglishData";
        private readonly IFileReader _fileReader;
        private readonly Database _database;

        public DefaultDataProvider(IFileReader fileReader, Database database)
        {
            _fileReader = fileReader;
            _database = database;
        }

        public void Initialize()
        {
            foreach (var fileName in System.IO.Directory.EnumerateFiles(Directory))
            {
                var content = _fileReader.ReadFile(fileName);
                Process(content, new DirectoryInfo(fileName).Name);
            }
            _database.SaveChanges();
        }

        private void Process(string content, string fileName)
        {
            var words = Regex.Split(content, "\\s+").Select(w => w.ToLower())
                .Select(w => Regex.Replace(w, "[^a-zA-Z0-9]", "")).Distinct();
            foreach (var word in words)
            {
                AddWordToDataBase(word, fileName); ;
            }
        }

        private void AddWordToDataBase(string word, string fileName)
        {
            var wordAndAddressWrapper = new WordAndAddressWrapper()
            {
                Word = word,
                Address = int.Parse(fileName)
            };
            _database.WordAndAddressWrapper.Add(wordAndAddressWrapper);
        }
    }
}