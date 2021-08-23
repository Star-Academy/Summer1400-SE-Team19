using Search.modifiers.filterers;

namespace Search.LibraryConfig
{
    public delegate IFilterer<string> ServiceResolver(string key);
}