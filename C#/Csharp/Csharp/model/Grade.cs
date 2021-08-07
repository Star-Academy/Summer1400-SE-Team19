using System.Collections.Generic;

namespace Csharp.model
{
    public class Grade
    {
        public readonly int StudentNumber;
        public string Lesson;
        public readonly double Score;

        public Grade(int studentNumber, string lesson, double score)
        {
            StudentNumber = studentNumber;
            Lesson = lesson;
            Score = score;
        }
    }
}