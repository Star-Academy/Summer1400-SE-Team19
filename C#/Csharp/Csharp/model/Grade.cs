using System.Collections.Generic;

namespace Csharp.model
{
    public class Grade
    {
        private static List<Grade> _allGrades;
        private int _studentNumber;
        private string _lesson;
        private double _score;

        public Grade(int studentNumber, string lesson, double score)
        {
            _studentNumber = studentNumber;
            _lesson = lesson;
            _score = score;
        }
    }
}