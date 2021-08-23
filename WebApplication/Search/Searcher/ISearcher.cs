using System.Collections.Generic;

namespace Search.Searcher
{
    public interface ISearcher
    {
        IEnumerable<string> Search(string searchedNote);
    }
}