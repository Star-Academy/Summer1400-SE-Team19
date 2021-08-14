using System.IO;

namespace InvertedIndexSearcher.database
{
    public class FileReader : IFileReader
    {
        public string ReadFile(string path)
        {
            return File.ReadAllText(path);
        }
    }
}