using System.Collections.Generic;

namespace InvertedIndexSearcher
{
    public interface ISearcher
    {
        IEnumerable<int> Search(string searchedNote);
    }
}