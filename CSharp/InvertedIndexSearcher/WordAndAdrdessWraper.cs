using System.ComponentModel.DataAnnotations;

namespace InvertedIndexSearcher
{
    public class WordAndAddressWrapper
    {
        
        [Key]
        public string Word { get; set; }
        public int Address { get; set; }
    }
}