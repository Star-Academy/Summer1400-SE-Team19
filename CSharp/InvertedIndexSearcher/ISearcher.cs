using System.Collections.Generic;

namespace InvertedIndexSearcher
{
    public interface ISearcher
    {
        HashSet<int> Search(string searchedNote);
    }
}