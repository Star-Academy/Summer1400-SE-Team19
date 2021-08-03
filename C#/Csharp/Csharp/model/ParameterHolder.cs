using System.Collections.Generic;
using System.IO;
using Csharp.controller;
using Csharp.view;

namespace Csharp.model
{
    public class ParameterHolder
    {
        public StreamReader StudentsStreamReader { get; set; }
        public StreamReader GradesStreamReader { get; set; }
        public Dictionary<Student, double> StudentGpaDictionary { get; set; }
        public IDataProvider<Student, Grade> StudentsAndGradesProvider { get; set; }
        public IDisplay<Student, double> DisplayStudents { get; set; }
        public IDataAnalyser<Student, double> TopStudentsAnalyzer { get; set; }
        public IReader FileReader { get; set; }
        public Dictionary<Student, double> TopStudents { get; set; }
    }
}