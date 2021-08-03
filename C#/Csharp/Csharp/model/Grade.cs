using System.Collections.Generic;

namespace Csharp.model
{
    public class Grade
    {
        public static List<Grade> AllGrades { get; set; }
        public int StudentNumber;
        public string Lesson;
        public double Score;

        public Grade(int studentNumber, string lesson, double score)
        {
            StudentNumber = studentNumber;
            Lesson = lesson;
            Score = score;
        }
    }
}