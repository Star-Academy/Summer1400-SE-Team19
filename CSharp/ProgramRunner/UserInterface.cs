using System;
using InvertedIndexSearcher.modifiers;

namespace ProgramRunner
{

    public class UserInterface
    {
        private const string LastWord = "#end";
        private IFilterer _filterer;

        public UserInterface(IFilterer filterer)
        {
            _filterer = filterer;
        }

        public void Run()
        {
            while (true)
            {
                string input = Console.ReadLine();
                if (input == LastWord)
                    break;
                string output = Process(input);
                Console.WriteLine(output);
            }
        }

        public string Process(string input)
        {
            return "nope";
        }
    }
}