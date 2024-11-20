using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.exceptions
{
    public class SubscricaoInativaException: Exception
    {
        public SubscricaoInativaException() : base("Subscricao Inativa")
        {
        }
    }
}
