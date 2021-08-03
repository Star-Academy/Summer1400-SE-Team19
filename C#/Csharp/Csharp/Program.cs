using System;
using System.IO;
using Csharp.controller;

namespace Csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            JsonFileReader fileReader = new JsonFileReader();
            string sFilePath = Path.GetFullPath("resources/Students.json");
            fileReader.ReadStudents(sFilePath);
            sFilePath = Path.GetFullPath("resources/Grades.json");
            fileReader.ReadGrades(sFilePath);
        }
    }
}