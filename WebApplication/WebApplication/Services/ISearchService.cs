using System.Collections.Generic;

namespace WebApplication.Services
{
    public interface ISearchService
    {
        IEnumerable<int> GetSearchResult(string text);
    }
}