using Microsoft.EntityFrameworkCore.Migrations;

namespace InvertedIndexSearcher.Migrations
{
    public partial class ID : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropPrimaryKey(
                name: "PK_WordAndAddressWrappers",
                table: "WordAndAddressWrappers");

            migrationBuilder.AlterColumn<string>(
                name: "Word",
                table: "WordAndAddressWrappers",
                type: "nvarchar(max)",
                nullable: true,
                oldClrType: typeof(string),
                oldType: "nvarchar(450)");

            migrationBuilder.AddColumn<int>(
                name: "Id",
                table: "WordAndAddressWrappers",
                type: "int",
                nullable: false,
                defaultValue: 0)
                .Annotation("SqlServer:Identity", "1, 1");

            migrationBuilder.AddPrimaryKey(
                name: "PK_WordAndAddressWrappers",
                table: "WordAndAddressWrappers",
                column: "Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropPrimaryKey(
                name: "PK_WordAndAddressWrappers",
                table: "WordAndAddressWrappers");

            migrationBuilder.DropColumn(
                name: "Id",
                table: "WordAndAddressWrappers");

            migrationBuilder.AlterColumn<string>(
                name: "Word",
                table: "WordAndAddressWrappers",
                type: "nvarchar(450)",
                nullable: false,
                defaultValue: "",
                oldClrType: typeof(string),
                oldType: "nvarchar(max)",
                oldNullable: true);

            migrationBuilder.AddPrimaryKey(
                name: "PK_WordAndAddressWrappers",
                table: "WordAndAddressWrappers",
                column: "Word");
        }
    }
}
