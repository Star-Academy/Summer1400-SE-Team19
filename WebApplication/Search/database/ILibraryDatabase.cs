using Microsoft.EntityFrameworkCore;
using Search.words;

namespace Search.database
{
    public interface ILibraryDatabase
    {
        DbSet<WordAndAddressWrapper> WordAndAddressWrapper { get; }
        int SaveChanges();
    }
}