using System.Collections.Generic;
using System.Linq;
using Csharp.model;

namespace Csharp.controller
{
    public class TopStudentsAnalyser : IDataAnalyser<Student, double>
    {
        private Dictionary<Student, List<Grade>> StudentGradesDictionary { get; set; }

        public Dictionary<Student, double> Analyse()
        {
            IDataProvider<Student, Grade> studentsAndGradesProvider = new StudentsAndGradesProvider();
            StudentGradesDictionary =
                studentsAndGradesProvider.Provide(DataBasesManagement.GetInstance().AllStudents.AllPropertiesOfThisType,
                    DataBasesManagement.GetInstance().AllGrades.AllPropertiesOfThisType);

            var studentAndGradeDictionary = CalculateGpaForEachStudent();
            return SelectTopStudents(studentAndGradeDictionary , 3);
        }

        private Dictionary<Student, double> SelectTopStudents(Dictionary<Student  , double> studentAndGradeDictionary , int numberOfStudents)
        {
            var result = studentAndGradeDictionary.
                OrderByDescending(x => x.Value).Take(numberOfStudents)
                .ToDictionary(x => x.Key, x => x.Value);
            return result;
        }

        private Dictionary<Student, double> CalculateGpaForEachStudent()
        {
            var studentAndGradeDictionary = StudentGradesDictionary.ToDictionary(
                x => x.Key,
                v => v.Value.Average(g => g.Score));
            return studentAndGradeDictionary; 
        }
    }
}