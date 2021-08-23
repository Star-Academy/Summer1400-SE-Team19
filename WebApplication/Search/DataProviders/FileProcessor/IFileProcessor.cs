using System.Collections.Generic;

namespace Search.DataProviders.FileProcessor
{
    public interface IFileProcessor<in T>
    {
        IEnumerable<string> Process(T content);
    }
}