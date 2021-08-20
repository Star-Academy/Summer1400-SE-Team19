using System.IO;
using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;

namespace InvertedIndexSearcher.DataProviders.Aggregators
{
    public class TextFileDataProvider : IDataProvider<string>
    {
        public TextFileDataProvider(IReader<string> reader, IFileProcessor<string> processor,
            IDataBaseUpdater<string> updater)
        {
            Reader = reader;
            Processor = processor;
            Updater = updater;
        }

        public IReader<string> Reader { get; }
        public IFileProcessor<string> Processor { get; }
        public IDataBaseUpdater<string> Updater { get; }

        public void IndexFile(string path)
        {
            var fileName = Path.GetFileName(path);
            
            var content = Reader.Read(path);
            var tokens = Processor.Process(content);
            Updater.AddData(fileName, tokens);
        }
    }
}