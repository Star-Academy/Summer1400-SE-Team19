using InvertedIndexSearcher.words;
using Microsoft.EntityFrameworkCore;

namespace InvertedIndexSearcher.database
{
    public interface ILibraryDatabase
    {
        DbSet<WordAndAddressWrapper> WordAndAddressWrapper { get; }
        int SaveChanges();
    }
}