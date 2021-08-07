using System.Collections.Generic;
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
            string gradesFilePath = Path.GetFullPath("resources/Grades.json");
            
            var newStudents = fileReader.Read<Student>(studentsFilePath);
            var newGrades = fileReader.Read<Grade>(gradesFilePath);
            
            
            UpdateDataBase(newStudents, newGrades);
        }

        private static void UpdateDataBase(List<Student> newStudents, List<Grade> newGrades)
        {
            DataBasesManagement.GetInstance().UpdateStudents(newStudents);
            DataBasesManagement.GetInstance().UpdateGrades(newGrades);
        }
    }
}