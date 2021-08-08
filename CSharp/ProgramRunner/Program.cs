using System;
using System.Collections.Generic;
using InvertedIndexSearcher;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.modifiers;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace ProgramRunner
{
    static class Program
    {
        private static IServiceProvider _serviceProvider;

        static void Main()
        {
            CreateHost();
            var dataProvider = (DataProvider) _serviceProvider.GetService(typeof(DataProvider));
            dataProvider?.Initialize();
            var userInterface = (UserInterface) _serviceProvider.GetService(typeof(UserInterface));
            userInterface?.Run();
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
                services.AddSingleton<IFileReader, FileReader>();
                services.AddSingleton<IDataContainer<string, HashSet<int>>, DataContainer>();
                services.AddSingleton<DataProvider>();
            }).Build();
            _serviceProvider = host.Services;
        }
    }
}