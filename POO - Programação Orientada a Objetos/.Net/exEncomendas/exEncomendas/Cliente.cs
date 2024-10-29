using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exEncomendas
{
    public class Cliente
    {
        public string Nome { get; set; }
        public Boolean Desconto { get; set; }

        public Cliente(string Nome, Boolean Desconto)
        {
            this.Nome = Nome;
            this.Desconto = Desconto;
        }
    }
}
