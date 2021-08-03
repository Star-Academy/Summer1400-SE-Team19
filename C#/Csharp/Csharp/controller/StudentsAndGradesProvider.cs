using System.Collections.Generic;
using Csharp.model;

namespace Csharp.controller
{
    public class StudentsAndGradesProvider : IDataProvider<Student, Grade>
    {
        public Dictionary<Student, Grade> Provide(List<Student> key, List<Grade> value)
        {
            Dictionary<Student, Grade> dictionary = new Dictionary<Student, Grade>();
            
        }
    }
}