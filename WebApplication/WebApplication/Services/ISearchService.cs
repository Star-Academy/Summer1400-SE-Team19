using System.Collections.Generic;

namespace WebApplication.Services
{
    public interface ISearchService
    {
        IEnumerable<string> GetSearchResult(string text);
    }
}