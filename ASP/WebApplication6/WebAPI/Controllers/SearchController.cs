using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace WebApplication6.Controllers
{
    
    [ApiController]
    [Route("[controller]")]
    public class SearchController : ControllerBase
    {

        [HttpGet("{input}")]
        [Route("text")]
        [ProducesResponseType(StatusCodes.Status200OK, Type = typeof(string))]
        public IActionResult SearchText(string input)
        {
            return null;
        }
    }
}