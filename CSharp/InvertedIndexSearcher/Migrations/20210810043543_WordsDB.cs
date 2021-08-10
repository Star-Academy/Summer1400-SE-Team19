using Microsoft.EntityFrameworkCore.Migrations;

namespace InvertedIndexSearcher.Migrations
{
    public partial class WordsDB : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "WordAndAddressWrappers",
                columns: table => new
                {
                    Word = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Address = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_WordAndAddressWrappers", x => x.Word);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "WordAndAddressWrappers");
        }
    }
}
