using System.Collections.Generic;
using System.Linq;
using Csharp.model;

namespace Csharp.controller
{
    public class TopStudentsAnalyser : IDataAnalyser<Student, double>
    {
        public Dictionary<Student, List<Grade>> StudentGradesDictionary { get; set; }
        public Dictionary<Student, double> StudentGpaDictionary;

        public Dictionary<Student, double> Analyse()
        {
            IDataProvider<Student, Grade> studentsAndGradesProvider = new StudentsAndGradesProvider();
            StudentGradesDictionary =
                studentsAndGradesProvider.Provide(DataBasesManagement.GetInstance().AllStudents.AllPropertiesOfThisType,
                    DataBasesManagement.GetInstance().AllGrades.AllPropertiesOfThisType);

            CalculateGpaForEachStudent();
            return SelectTopStudents(3);
        }

        private Dictionary<Student, double> SelectTopStudents(int numberOfStudents)
        {
            Dictionary<Student, double> topStudents = new Dictionary<Student, double>();
            for (int i = 0; i < numberOfStudents; i++)
            {
                var topStudent = StudentGpaDictionary.OrderByDescending(x => x.Value).Skip(i).First();
                topStudents.Add(topStudent.Key, topStudent.Value);
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