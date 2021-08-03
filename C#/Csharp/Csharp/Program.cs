namespace Csharp
{
    public static class Program
    {
        private static NewInstancesInitializer _newInstancesInitializer;
        public static void Main()
        {
            _newInstancesInitializer = new NewInstancesInitializer();
            _newInstancesInitializer.Initialize();
            ReadFromJson();
            Process();
        }

        private static void Process()
        {
            var displayStudents = _newInstancesInitializer.ParameterHolder.DisplayStudents;
            var topStudentsAnalyser = _newInstancesInitializer.ParameterHolder.TopStudentsAnalyzer;
            displayStudents.Display(topStudentsAnalyser.Analyse());
        }

        private static void ReadFromJson()
        {
            var fileReader = _newInstancesInitializer.ParameterHolder.FileReader;
            fileReader.ReadStudents();
            fileReader.ReadGrades();
        }
    }
}