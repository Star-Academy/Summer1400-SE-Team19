using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace InvertedIndexSearcher.words
{
    public class WordAndAddressWrapper
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        public string Word { get; init; }
        public string Address { get; init; }
    }
}