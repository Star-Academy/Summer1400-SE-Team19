using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.OpenApi.Models;
using InvertedIndexSearcher;
using InvertedIndexSearcher.database;
using InvertedIndexSearcher.database.dataproviders;
using InvertedIndexSearcher.modifiers;
using InvertedIndexSearcher.modifiers.filterers;

namespace WebApplication6
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllers();
            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo {Title = "WebAPI", Version = "v1"});
            });
            services.AddSingleton<IPositivesWordFilterer, PositivesWordFilterer>();
            services.AddSingleton<INeutralsWordFilterer, NeutralsWordFilterer>();
            services.AddSingleton<INegativesWordFilterer, NegativesWordFilterer>();
            services.AddSingleton<ITypeChecker, TypeChecker>();
            services.AddSingleton<IDataCollector, DataCollector>();
            services.AddSingleton<ISearcher, Searcher>();
            services.AddSingleton<IFileReader, FileReader>();
            services.AddSingleton<Database>();
            services.AddSingleton<IDataProvider, DefaultDataProvider>();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "WebAPI v1"));
            }

            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints => { endpoints.MapControllers(); });
        }
    }
}