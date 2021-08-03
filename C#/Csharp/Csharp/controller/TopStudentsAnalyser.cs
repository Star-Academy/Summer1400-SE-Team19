using System.Collections.Generic;
using System.Linq;
using Csharp.model;

namespace Csharp.controller
{
    public class TopStudentsAnalyser : IDataAnalyser<Student>
    {
        public Dictionary<Student, List<Grade>> StudentGradesDictionary { get; set; }
        public Dictionary<Student, double> StudentGpaDictionary;

        public List<Student> Analyse()
        {
            IDataProvider<Student, Grade> studentsAndGradesProvider = new StudentsAndGradesProvider();
            StudentGradesDictionary = studentsAndGradesProvider.Provide(Student.AllStudents, Grade.AllGrades);
            CalculateGpaForEachStudent();
            return SelectTopStudents(3);
        }

        private List<Student> SelectTopStudents(int numberOfStudents)
        {
            List<Student> topStudents = new List<Student>();
            for (int i = 0; i < numberOfStudents; i++)
            {
                Student topStudent = StudentGpaDictionary.OrderByDescending(x => x.Value).Skip(i).First().Key;
                topStudents.Add(topStudent);
            }

            return topStudents;
        }

        private void CalculateGpaForEachStudent()
        {
            StudentGpaDictionary = new Dictionary<Student, double>();
            foreach (var iterator in StudentGradesDictionary)
            {
                var student = iterator.Key;
                var grades = iterator.Value;
                double gpa = grades.Average(g => g.Score);
                StudentGpaDictionary.Add(student, gpa);
            }
        }
    }
}