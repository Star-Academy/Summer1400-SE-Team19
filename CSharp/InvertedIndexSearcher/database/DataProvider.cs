﻿using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace InvertedIndexSearcher.database
{
    public class DataProvider : IDataProvider
    {
        private const string Directory = "../../../../InvertedIndexSearcher/resources/SampleEnglishData";
        private readonly IFileReader _fileReader;
        //private int _totalNumberOfReadWords;
        private readonly Database _database;

        public DataProvider(IFileReader fileReader, Database database)
        {
            _fileReader = fileReader;
            //_totalNumberOfReadWords = 0;
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
                AddWordToDataBase(word, fileName);
                //_totalNumberOfReadWords++;
            }
        }

        private void AddWordToDataBase(string word, string fileName)
        {
            var wordAndAddressWrapper = new WordAndAddressWrapper()
            {
                Word = word,
                Address = int.Parse(fileName)
            };
            _database.WordAndAddressWrappers.Add(wordAndAddressWrapper);
        }
    }
}