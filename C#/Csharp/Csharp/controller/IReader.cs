using System.Collections.Generic;
using Csharp.model;

namespace Csharp.controller
{
    public interface IReader
    {
        List<T> Read<T>(string address); 
    }
}