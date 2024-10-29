using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exEncomendas
{
    public class Produto
    {
        public string Nome { get; set; }
        public decimal Preco { get; set; }

        public Produto(string Nome, decimal Preco)
        {
            this.Nome = Nome;
            this.Preco = Preco;
        }
    }
}
