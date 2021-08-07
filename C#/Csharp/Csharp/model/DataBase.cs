using System.Collections.Generic;

namespace Csharp.model
{
    public class DataBase<T>
    {
        public DataBase()
        {
            AllPropertiesOfThisType = new List<T>();
        }

        public List<T> AllPropertiesOfThisType { get; }
    }
}