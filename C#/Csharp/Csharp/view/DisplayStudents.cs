using System;
using System.Collections.Generic;
using Csharp.model;

namespace Csharp.view
{
    public class DisplayStudents : IDisplay<Student>
    {
        public void Display(List<Student> list)
        {
            foreach (var student in list)
            {
                Console.WriteLine($"{student.FirstName} {student.LastName}");
            }
        }
    }
}