using System;
using System.Collections.Generic;
using Microsoft.Extensions.DependencyInjection;
using Search.database;
using Search.DataProviders.Aggregators;
using Search.DataProviders.DatabaseUpdater;
using Search.DataProviders.FileProcessor;
using Search.DataProviders.Readers;
using Search.modifiers;
using Search.modifiers.filterers;
using Search.Searcher;

namespace Search.LibraryConfig
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