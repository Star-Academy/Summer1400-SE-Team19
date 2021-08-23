using System;
using InvertedIndexSearcher.LibraryConfig;
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
            var userInterface = (UserInterface) _serviceProvider.GetService(typeof(UserInterface));
            userInterface?.Run();
        }

        private static void CreateHost()
        {
            var host = Host.CreateDefaultBuilder().ConfigureServices((_, services) =>
            {
                services.ConfigDependencies(typeof(DatabaseTest));
                services.AddSingleton<UserInterface>();
            }).Build();
            _serviceProvider = host.Services;
        }
    }
}