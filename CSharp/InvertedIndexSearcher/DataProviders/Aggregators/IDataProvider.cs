using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;

namespace InvertedIndexSearcher.DataProviders.Aggregators
{
    public interface IDataProvider<T>
    {
        IReader<T> Reader { get; }
        IFileProcessor<T> Processor { get; }
        IDataBaseUpdater<T> Updater { get; }
    }
}