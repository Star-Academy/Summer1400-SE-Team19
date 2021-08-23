using System.IO;

namespace Search.DataProviders.Readers
{
    internal class TextFileReader : IReader
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