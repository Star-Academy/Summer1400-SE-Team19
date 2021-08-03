using System.Collections.Generic;
using System.IO;
using Csharp.controller;
using Csharp.model;
using Csharp.view;

namespace Csharp
{
    public class NewInstancesInitializer
    {
        public ParameterHolder ParameterHolder { get; }

        public NewInstancesInitializer()
        {
            ParameterHolder = new ParameterHolder();
        }

        public void Initialize()
        {
            ParameterHolder.GradesStreamReader = new StreamReader(Path.GetFullPath("resources/Grades.json"));
            ParameterHolder.StudentsStreamReader = new StreamReader(Path.GetFullPath("resources/Students.json"));
            ParameterHolder.StudentGpaDictionary = new Dictionary<Student, double>();
            ParameterHolder.StudentsAndGradesProvider = new StudentsAndGradesProvider();
            ParameterHolder.DisplayStudents = new DisplayStudents();
            ParameterHolder.TopStudents = new Dictionary<Student, double>();
            ParameterHolder.TopStudentsAnalyzer = new TopStudentsAnalyser(ParameterHolder);
            ParameterHolder.FileReader = new JsonFileReader(ParameterHolder);
        }
    }
}