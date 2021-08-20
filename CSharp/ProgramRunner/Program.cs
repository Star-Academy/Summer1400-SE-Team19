using System;
using System.IO;
using InvertedIndexSearcher;
using InvertedIndexSearcher.DataProviders.Aggregators;
using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;
using InvertedIndexSearcher.Searcher;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Database = InvertedIndexSearcher.database.Database;

namespace ProgramRunner
{
    static class Program
    {
        private static IServiceProvider _serviceProvider;

        static void Main()
        {
            CreateHost();
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
                services.AddSingleton<IReader<string>, TextFileReader>();
                services.AddSingleton<IFileProcessor<string>, TextFileProcessor>();
                services.AddSingleton<IDataBaseUpdater<string>, DataBaseWordDataUpdater>();
                services.AddSingleton<IDataProvider<string>, TextFileDataProvider>();
                services.AddSingleton<Database>();
            }).Build();
            _serviceProvider = host.Services;
        }
    }
}