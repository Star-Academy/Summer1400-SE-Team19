using System.Collections.Generic;
using System.Linq;
using Csharp.model;

namespace Csharp.controller
{
    public class TopStudentsAnalyser : IDataAnalyser<Student, double>
    {
        private Dictionary<Student, List<Grade>> _studentGradesDictionary;
        private readonly Dictionary<Student, double> _studentGpaDictionary;
        private readonly IDataProvider<Student, Grade> _studentsAndGradesProvider;
        private readonly Dictionary<Student, double> _topStudents;

        public TopStudentsAnalyser(ParameterHolder parameterHolder)
        {
            _studentGpaDictionary = parameterHolder.StudentGpaDictionary;
            _studentsAndGradesProvider = parameterHolder.StudentsAndGradesProvider;
            _topStudents = parameterHolder.TopStudents;
        }

        public Dictionary<Student, double> Analyse()
        {
            _studentGradesDictionary = _studentsAndGradesProvider.Provide(Student.AllStudents, Grade.AllGrades);
            CalculateGpaForEachStudent();
            return SelectTopStudents(3);
        }

        private Dictionary<Student, double> SelectTopStudents(int numberOfStudents)
        {
            for (int i = 0; i < numberOfStudents; i++)
            {
                var topStudent = _studentGpaDictionary.OrderByDescending(x => x.Value).Skip(i).First();
                _topStudents.Add(topStudent.Key, topStudent.Value);
            }

            return _topStudents;
        }

        private void CalculateGpaForEachStudent()
        {
            foreach (var (student, grades) in _studentGradesDictionary)
            {
                double gpa = grades.Average(g => g.Score);
                _studentGpaDictionary.Add(student, gpa);
            }
        }
    }
}