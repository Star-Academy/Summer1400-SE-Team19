using System.Collections.Generic;

namespace InvertedIndexSearcher.DataProviders.FileProcessor
{
    public interface IFileProcessor<in T>
    {
        IEnumerable<string> Process(T content);
    }
}