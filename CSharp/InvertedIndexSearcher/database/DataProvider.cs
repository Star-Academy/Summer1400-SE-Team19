
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace InvertedIndexSearcher.database 
{
    public class DataProvider
    {
        private readonly IDataContainer<string, HashSet<int>> _dataContainer;
        private const string Directory = "../../../../resources/SampleEnglishData";
        private readonly IFileReader _fileReader;

        public DataProvider(IDataContainer<string, HashSet<int>> dataContainer, IFileReader fileReader)
        {
            _dataContainer = dataContainer;
            _fileReader = fileReader;
        }

        public void Initialize()
        {
            foreach (string fileName in System.IO.Directory.EnumerateFiles(Directory))
            {
                string content = _fileReader.ReadFile(fileName);
                Process(content, new DirectoryInfo(fileName).Name);
            }
        }

        private void Process(string content, string fileName)
        {
            var words = Regex.Split(content, "\\s+").Select(w => w.ToLower())
                .Select(w => Regex.Replace(w, "[^a-zA-Z0-9]", ""));
            foreach (string word in words)
            {
                AddWordToDataBase(word, fileName);
            }
        }

        private void AddWordToDataBase(string word, string fileName)
        {
            if (_dataContainer.GetAllData().TryGetValue(word, out var hashSet))
            {
                hashSet.Add(int.Parse(fileName));
            }
            else
            {
                _dataContainer.GetAllData().Add(word, new HashSet<int>() {int.Parse(fileName)});
            }
        }
    }
}