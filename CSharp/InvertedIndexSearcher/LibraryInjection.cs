using System;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.DataProviders.Aggregators;
using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;
using InvertedIndexSearcher.Searcher;
using Microsoft.Extensions.DependencyInjection;

namespace InvertedIndexSearcher
{
    public static class LibraryInjection
    {
        public static void ConfigDependencies(this IServiceCollection serviceProvider)
        {
            serviceProvider.AddSingleton<IPositivesWordFilterer, PositivesWordFilterer>();
            serviceProvider.AddSingleton<INeutralsWordFilterer, NeutralsWordFilterer>();
            serviceProvider.AddSingleton<INegativesWordFilterer, NegativesWordFilterer>();
            serviceProvider.AddSingleton<ITypeChecker, TypeChecker>();
            serviceProvider.AddSingleton<IDataCollector, DataCollector>();
            serviceProvider.AddSingleton<ISearcher, Searcher.Searcher>();
            serviceProvider.AddSingleton<IReader<string>, TextFileReader>();
            serviceProvider.AddSingleton<IFileProcessor<string>, TextFileProcessor>();
            serviceProvider.AddSingleton<IDataBaseUpdater<string>, DataBaseWordDataUpdater>();
            serviceProvider.AddSingleton<IDataProvider<string>, TextFileDataProvider>();
            serviceProvider.AddSingleton<Database>();
        }
    }
}