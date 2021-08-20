using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace InvertedIndexSearcher.DataProviders.FileProcessor
{
    public class TextFileProcessor : IFileProcessor<string>
    {
        public IEnumerable<string> Process(string content)
        {
            var stemmedWords = Regex.Split(content, "\\s+").Select(w => w.ToLower())
                .Select(w => Regex.Replace(w, "[^a-zA-Z0-9]", "")).Distinct();
            return stemmedWords;
        }
    }
}