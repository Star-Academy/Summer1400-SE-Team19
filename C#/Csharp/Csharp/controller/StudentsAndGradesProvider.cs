using System.Collections.Generic;
using System.Linq;
using Csharp.model;

namespace Csharp.controller
{
    public class StudentsAndGradesProvider : IDataProvider<Student, Grade>
    {
        public Dictionary<Student, List<Grade>> Provide(List<Student> students, List<Grade> grades)
        {
            Dictionary<Student, List<Grade>> dictionary = new Dictionary<Student, List<Grade>>();
            var studentNumAndGradesGroup = 
                grades.GroupBy(g => g.StudentNumber).ToDictionary(x => x.Key);
            
            return students.ToDictionary(s => s,
                s => studentNumAndGradesGroup[s.StudentNumber].ToList());
        }
    }
}