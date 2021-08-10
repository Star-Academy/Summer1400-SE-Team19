using Microsoft.EntityFrameworkCore;

namespace InvertedIndexSearcher
{
    public class Database : DbContext
    {
        public DbSet<WordAndAddressWrapper> WordAndAddressWrappers { set; get; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=.\SQLEXPRESS;Database=WordsDB;Trusted_Connection=True;");
        }
    }
}