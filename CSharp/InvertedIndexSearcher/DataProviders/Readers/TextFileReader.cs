﻿using System.IO;

namespace InvertedIndexSearcher.DataProviders.Readers
{
    public class TextFileReader : IReader
    {
        public string Read(string path)
        {
            try
            {
                return File.ReadAllText(path);
            }
            catch (FileNotFoundException)
            {
                throw new FileNotFoundException("wrong address");
            }
        }
    }
}