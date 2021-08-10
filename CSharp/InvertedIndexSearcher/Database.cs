using Microsoft.EntityFrameworkCore;

namespace InvertedIndexSearcher
{
    public class Database : DbContext
    {
        public DbSet<WordAndAddressWrapper> WordAndAddressWrapper { set; get; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=localhost;Database=Phase8;Trusted_Connection=True;");
        }
    }
}