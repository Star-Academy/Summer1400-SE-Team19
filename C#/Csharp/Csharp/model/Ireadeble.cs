using System.Collections.Generic;

namespace Csharp.model
{
    public interface Ireadeble<T>
    {
        void SetProperty(List<T> listOfReadableData);
    }
}