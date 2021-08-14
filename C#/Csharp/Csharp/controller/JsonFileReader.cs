using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices;
using Csharp.model;
using Newtonsoft.Json;

namespace Csharp.controller
{
    public class JsonFileReader : IReader
    {
        
        private static string MakeStringJson(string address)
        {
            using StreamReader streamReader = new StreamReader(address);
            string json = streamReader.ReadToEnd();
            return json;
        }

        public List<T> Read<T>(string address)
        {
            var json = MakeStringJson(address);
            var listOfJsonObjects = JsonConvert.DeserializeObject<List<T>>(json);
            return listOfJsonObjects;
        }
    }
}