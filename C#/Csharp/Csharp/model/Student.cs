using System.Collections.Generic;

namespace Csharp.model
{
    public class Student
    {
        public static List<Student> AllStudents { set; get; }
        public int StudentNumber;
        public string FirstName;
        public string LastName;

        public Student(int studentNumber, string firstName, string lastName)
        {
            StudentNumber = studentNumber;
            FirstName = firstName;
            LastName = lastName;
        }
    }
}