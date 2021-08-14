using System;
using System.Collections.Generic;
using Csharp.model;

namespace Csharp.view
{
    public class DisplayStudents : IDisplay<Student, double>
    {
        public void Display(Dictionary<Student, double> dictionary)
        {
            foreach (var (student, grade) in dictionary)
            {
                Console.WriteLine("{0} {1} {2:F3}", student.FirstName, student.LastName, grade);
            } 
        }
    }
}