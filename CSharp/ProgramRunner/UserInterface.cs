using System;
using InvertedIndexSearcher;

namespace ProgramRunner
{

    public class UserInterface
    {
        private readonly ISearcher _searcher;

        public UserInterface(ISearcher searcher)
        {
            _searcher = searcher;
        }
        
        public void Run()
        {
            string input = Console.ReadLine();
            var result = _searcher.Search(input);
            foreach (var i in result)
            {
                Console.WriteLine(i);
            }
        }
        
    }
}