using System.Collections.Generic;
using System.IO;
using Csharp.model;
using Newtonsoft.Json;

namespace Csharp.controller
{
    public class JsonFileReader : IReader
    {
        public void ReadStudents(string address)
        {
            var json = MakeStringJson(address);
            var model = JsonConvert.DeserializeObject<List<Student>>(json);
            Student.AllStudents = model;
        }
        public void ReadGrades(string address)
        {
            var json = MakeStringJson(address);
            var model = JsonConvert.DeserializeObject<List<Grade>>(json);
            Grade.AllGrades = model;
        }
        
        
        private static string MakeStringJson(string address)
        {
            using StreamReader streamReader = new StreamReader(address);
            string json = streamReader.ReadToEnd();
            return json;
        }
    }
}