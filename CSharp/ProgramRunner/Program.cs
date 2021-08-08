using System;
using InvertedIndexSearcher;
using InvertedIndexSearcher.modifiers;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace ProgramRunner
{
    class Program
    {
        private static IServiceProvider _serviceProvider;

        static void Main(string[] args)
        {
            CreateHost();
            var userInterface = (UserInterface) _serviceProvider.GetService(typeof(UserInterface));
            userInterface.Run();
        }

        private static void CreateHost()
        {
            var host = Host.CreateDefaultBuilder().ConfigureServices((_, services) =>
            {
                services.AddSingleton<UserInterface>();
                services.AddSingleton<IPositivesWordFilterer, PositivesWordFilterer>();
                services.AddSingleton<INeutralsWordFilterer, NeutralsWordFilterer>();
                services.AddSingleton<INegativesWordFilterer, NegativesWordFilterer>();
                services.AddSingleton<ITypeChecker, TypeChecker>();
                services.AddSingleton<IDataCollector, DataCollector>();
                services.AddSingleton<ISearcher, Searcher>();
                // services.AddSingleTon<interface, class>();
                // order of implementation is important!!!
            }).Build();
            _serviceProvider = host.Services;
        }
    }
}