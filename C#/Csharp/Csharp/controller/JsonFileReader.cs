using System.Collections.Generic;
using System.IO;
using Csharp.model;
using Newtonsoft.Json;

namespace Csharp.controller
{
    public class JsonFileReader : IReader
    {
        private readonly StreamReader _studentsStreamReader;
        private readonly StreamReader _gradesStreamReader;

        public JsonFileReader(ParameterHolder parameterHolder)
        {
            _studentsStreamReader = parameterHolder.StudentsStreamReader;
            _gradesStreamReader = parameterHolder.GradesStreamReader;
        }
        public void ReadStudents()
        {
            var json = MakeStringJson(_studentsStreamReader);
            var model = JsonConvert.DeserializeObject<List<Student>>(json);
            Student.AllStudents = model;
        }
        public void ReadGrades()
        {
            var json = MakeStringJson(_gradesStreamReader);
            var model = JsonConvert.DeserializeObject<List<Grade>>(json);
            Grade.AllGrades = model;
        }
        
        
        private static string MakeStringJson(StreamReader streamReader)
        {
            string json = streamReader.ReadToEnd();
            return json;
        }
    }
}