using System.Collections.Generic;
using InvertedIndexSearcher.Searcher;


namespace WebApplication.Services
{
    public class SearchService : ISearchService
    {
        private readonly ISearcher _searcher;

        public SearchService(ISearcher searcher)
        {
            _searcher = searcher;
        }

        public IEnumerable<string> GetSearchResult(string text)
        {
            var result = _searcher.Search(text);
            return result;
        }
    }
}