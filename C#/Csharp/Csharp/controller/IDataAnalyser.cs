using System.Collections.Generic;

namespace Csharp.controller
{
    public interface IDataAnalyser<T1, T2>
    {
        Dictionary<T1, T2> Analyse();
    }
}