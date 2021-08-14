﻿using System.Collections.Generic;

namespace Csharp.model
{
    public class Student
    {
        public int StudentNumber { get; }
        public string FirstName { get; }
        public string LastName { get; }

        public Student(int studentNumber, string firstName, string lastName)
        {
            StudentNumber = studentNumber;
            FirstName = firstName;
            LastName = lastName;
        }
    }
}