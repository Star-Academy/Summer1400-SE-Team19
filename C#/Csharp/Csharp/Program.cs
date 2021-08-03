using System;
using System.IO;
using Csharp.controller;

namespace Csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            JsonFileReader fileReader = new JsonFileReader();
            string sFilePath = Path.GetFullPath("Csharp/resources/Students.json");
            fileReader.Read(sFilePath);
        }
    }
}