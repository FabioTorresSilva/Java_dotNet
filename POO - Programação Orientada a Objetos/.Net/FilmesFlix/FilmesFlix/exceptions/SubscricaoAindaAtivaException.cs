using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.exceptions
{
    public class SubscricaoAindaAtivaException : Exception
    {
        // Construtor padrão
        public SubscricaoAindaAtivaException()
            : base("Ainda não é possível renovar a inscrição")
        {
        }

        // Construtor que permite passar uma mensagem personalizada
        public SubscricaoAindaAtivaException(string mensagem)
            : base(mensagem)
        {
        }

    }
}
