using System.IO;
using Csharp.controller;
using Csharp.model;
using Csharp.view;

namespace Csharp
{
    class Program
    {
        static void Main()
        {
            ReadFromJson();
            Process();
        }

        private static void Process()
        {
            IDisplay<Student> displayStudents = new DisplayStudents();
            IDataAnalyser<Student> topStudentsAnalyser = new TopStudentsAnalyser();
            displayStudents.Display(topStudentsAnalyser.Analyse());
        }

        private static void ReadFromJson()
        {
            IReader fileReader = new JsonFileReader();
            string studentsFilePath = Path.GetFullPath("resources/Students.json");
            fileReader.ReadStudents(studentsFilePath);
            string gradesFilePath = Path.GetFullPath("resources/Grades.json");
            fileReader.ReadGrades(gradesFilePath);
        }
    }
}