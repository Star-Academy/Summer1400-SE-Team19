using System.Collections.Generic;

namespace Csharp.controller
{
    public interface IGetObjectByProperty<T1, in T2>
    {
        T1 GetByProperty(List<T1> list, T2 property);
    }
}