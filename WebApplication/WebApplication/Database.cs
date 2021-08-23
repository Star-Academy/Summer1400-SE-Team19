using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;
using Microsoft.EntityFrameworkCore;

namespace WebApplication
{
    public class Database : DbContext, ILibraryDatabase
    {
        public DbSet<WordAndAddressWrapper> WordAndAddressWrapper { get; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=localhost;Database=invertedIndexLibraryTest;Trusted_Connection=True;");
        }
    }
}