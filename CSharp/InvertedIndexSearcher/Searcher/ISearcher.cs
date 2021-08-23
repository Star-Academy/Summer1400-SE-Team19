using System.Collections.Generic;

namespace InvertedIndexSearcher.Searcher
{
    public interface ISearcher
    {
        IEnumerable<string> Search(string searchedNote);
    }
}