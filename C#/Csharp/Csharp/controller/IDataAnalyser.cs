using System.Collections.Generic;

namespace Csharp.controller
{
    public interface IDataAnalyser<T>
    {
        
        List<T> Analyse();
    }
}