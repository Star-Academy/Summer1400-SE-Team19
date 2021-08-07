using System.Collections.Generic;

namespace Csharp.view
{
    public interface IDisplay<T1, T2>
    {
        void Display(Dictionary<T1, T2> dictionary);
    }
}