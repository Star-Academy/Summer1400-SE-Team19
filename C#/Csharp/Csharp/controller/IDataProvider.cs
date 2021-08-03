using System.Collections.Generic;

namespace Csharp.controller
{
    public interface IDataProvider<T1, T2>
    {
        Dictionary<T1, T2> Provide(List<T1> key, List<T2> value);
    }
}