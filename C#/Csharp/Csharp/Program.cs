﻿using System.IO;
using Csharp.controller;
using Csharp.model;
using Csharp.view;

namespace Csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            ReadFromJson();
            DisplayStudents displayStudents = new DisplayStudents();
            IDataAnalyser<Student> topStudentsAnalyser = new TopStudentsAnalyser();
            displayStudents.Display(topStudentsAnalyser.Analyse());
        }

        private static void ReadFromJson()
        {
            JsonFileReader fileReader = new JsonFileReader();
            string sFilePath = Path.GetFullPath("resources/Students.json");
            fileReader.ReadStudents(sFilePath);
            sFilePath = Path.GetFullPath("resources/Grades.json");
            fileReader.ReadGrades(sFilePath);
        }
    }
}