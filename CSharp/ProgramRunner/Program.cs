using System;
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
            var host = Host.CreateDefaultBuilder().ConfigureServices((context, services) =>
            {
                services.AddSingleton<UserInterface>();
                services.AddSingleton<IFilterer, Filterer>();
                // services.AddSingleTon<interface, class>();
                // order of implementation is important!!!
            }).Build();
            _serviceProvider = host.Services;
        }
    }
}