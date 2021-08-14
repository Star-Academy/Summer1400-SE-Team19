using System;
using System.Collections.Generic;
using System.Linq;

namespace Csharp.model
{
    public class DataBasesManagement
    {
        private static DataBasesManagement instance;

        public DataBase<Student> AllStudents { get; }
        public DataBase<Grade> AllGrades { get; }

        public DataBasesManagement()
        {
            AllStudents = new DataBase<Student>();
            AllGrades = new DataBase<Grade>();
        }

        public void UpdateStudents(IEnumerable<Student> newStudents)
        {
            AllStudents.AllPropertiesOfThisType.AddRange(newStudents);
        }

        public void UpdateGrades(IEnumerable<Grade> gradesFilePath)
        {
            AllGrades.AllPropertiesOfThisType.AddRange(gradesFilePath);
        }

        public static DataBasesManagement GetInstance()
        {
            return instance ??= new DataBasesManagement();
        }
    }
}