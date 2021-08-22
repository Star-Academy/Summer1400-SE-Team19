using System;
using System.Collections.Generic;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.DataProviders.Aggregators;
using InvertedIndexSearcher.DataProviders.DatabaseUpdater;
using InvertedIndexSearcher.DataProviders.FileProcessor;
using InvertedIndexSearcher.DataProviders.Readers;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;
using InvertedIndexSearcher.Searcher;
using Microsoft.Extensions.DependencyInjection;

namespace InvertedIndexSearcher.LibraryConfig
{
    public static class LibraryInjection
    {

        public static void ConfigDependencies(this IServiceCollection serviceProvider, Type databaseContextType)
        {
            serviceProvider.AddTransient<PositivesWordFilterer>();
            serviceProvider.AddTransient<NeutralsWordFilterer>();
            serviceProvider.AddTransient<NegativesWordFilterer>();
            serviceProvider.AddTransient<ServiceResolver>(provider => key =>
            {
                return key switch
                {
                    "positive" => provider.GetService<PositivesWordFilterer>(),
                    "neutral" => provider.GetService<NeutralsWordFilterer>(),
                    "negative" => provider.GetService<NegativesWordFilterer>(),
                    _ => throw new KeyNotFoundException()
                };
            });
            
            serviceProvider.AddSingleton<ITypeChecker, TypeChecker>();
            serviceProvider.AddSingleton<IDataCollector, DataCollector>();
            serviceProvider.AddSingleton<ISearcher, Searcher.Searcher>();
            
            serviceProvider.AddSingleton<IReader, TextFileReader>();
            serviceProvider.AddSingleton<IFileProcessor<string>, TextFileProcessor>();
            serviceProvider.AddSingleton<IDataBaseUpdater<string>, DataBaseWordDataUpdater>();
            serviceProvider.AddSingleton<IDataProvider, TextFileDataProvider>();
            
            serviceProvider.AddSingleton(typeof(ILibraryDatabase), databaseContextType);
        }
    }
}