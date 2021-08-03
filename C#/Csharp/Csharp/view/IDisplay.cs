using System.Collections.Generic;

namespace Csharp.view
{
    public interface IDisplay<T>
    {
        void Display(List<T> list);
    }
}