using System.IO;
using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;

namespace InvertedIndexSearcher.DataProviders.Aggregators
{
    public class TextFileDataProvider : IDataProvider
    {
        public TextFileDataProvider(IReader reader, IFileProcessor<string> processor,
            IDataBaseUpdater<string> updater)
        {
            _reader = reader;
            _processor = processor;
            _updater = updater;
        }

        private readonly IReader _reader;
        private readonly IFileProcessor<string> _processor;
        private readonly IDataBaseUpdater<string> _updater;

        public void IndexFile(string path)
        {
            var fileName = Path.GetFileName(path);
            
            var content = _reader.Read(path);
            var tokens = _processor.Process(content);
            _updater.AddData(fileName, tokens);
        }
    }
}