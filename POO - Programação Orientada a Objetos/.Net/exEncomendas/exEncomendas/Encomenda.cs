using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exEncomendas
{
    public class Encomenda
    {
        private Cliente Cliente { get; set; }
        public List<Produto> Produtos { get; set; }

        public Encomenda(Cliente cliente)
        {
            Cliente = cliente;
            Produtos = new List<Produto>();
        }

        public void AdicionarProduto(Produto produto)
        {
            Produtos.Add(produto);
        }

        public decimal CalcularTotal()
        {
            decimal total = 0;
            foreach (var produto in Produtos)
            {
                total += produto.Preco;
            }

            if (Cliente.Desconto)
            {
                total *= 0.9m;
            }

            return total;
        }
    }
}
