using InvertedIndexSearcher.database;
using InvertedIndexSearcher.words;
using Microsoft.EntityFrameworkCore;

namespace WebApplication.Database
{
    public class Database : DbContext, ILibraryDatabase
    {
        public DbSet<WordAndAddressWrapper> WordAndAddressWrapper { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            //change database and server fields based on your server and database
            optionsBuilder.UseSqlServer(@"Server=localhost;Database=InvertedIndexLibraryTest;Trusted_Connection=True;");
        }
    }
}