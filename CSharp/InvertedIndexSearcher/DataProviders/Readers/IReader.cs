namespace InvertedIndexSearcher.DataProviders.Readers
{
    public interface IReader<in T>
    {
        string Read(string path);
    }
}