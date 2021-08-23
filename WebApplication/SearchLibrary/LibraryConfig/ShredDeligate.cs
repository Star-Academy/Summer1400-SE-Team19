using InvertedIndexSearcher.modifiers.filterers;

namespace InvertedIndexSearcher.LibraryConfig
{
    public delegate IFilterer<string> ServiceResolver(string key);
}