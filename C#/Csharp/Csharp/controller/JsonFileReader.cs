using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using Csharp.model;
using Newtonsoft.Json;

namespace Csharp.controller
{
    public class JsonFileReader : IReader
    {
        public void Read(string address)
        {
            using (StreamReader r = new StreamReader(address))
            {
                string  json = r.ReadToEnd();  
                var model = JsonConvert.DeserializeObject<List<Student>>(json);
                foreach (Student student in model)
                {
                    Console.WriteLine(student);
                }
            }
        }
    }
}