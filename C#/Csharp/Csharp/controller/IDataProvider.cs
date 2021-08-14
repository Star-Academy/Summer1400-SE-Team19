using System.Collections.Generic;
using Csharp.model;

namespace Csharp.controller
{
    public interface IDataProvider<T1, T2>
    {
        Dictionary<Student, List<Grade>> Provide(List<T1> students, List<T2> grades);
    }
}