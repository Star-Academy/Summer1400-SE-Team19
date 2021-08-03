using System.Collections.Generic;
using Csharp.model;

namespace Csharp.controller
{
    public class TopStudentsAnalyser : IDataAnalyser<Student>
    {
        public Dictionary<Student, List<Grade>> StudentGradesDictionary { get; set; }
        
        public List<Student> Analyse()
        {
            
        }
    }
}