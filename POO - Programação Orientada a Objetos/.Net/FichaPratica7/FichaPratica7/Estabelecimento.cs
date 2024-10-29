using ficha7.interfaces;
using System.Collections;

namespace ficha7
{
    public abstract class Estabelecimento : IEstabelecimento
    {
        public string Nome { get; }

        public string Localizacao { get; set; }

        public int NumeroFuncionarios { get; set; }

        private readonly List<RegistoVenda> RegistosVendas;

        public Estabelecimento(string nome, string localizacao, int numeroFuncionarios)
        {
            this.Nome = nome;
            this.Localizacao = localizacao;
            this.NumeroFuncionarios = numeroFuncionarios;
            this.RegistosVendas = new List<RegistoVenda>();
        }

        public bool RegistarVenda(DateOnly data, double valor)
        {
            RegistoVenda registo = new RegistoVenda(data, valor);
            if (this.RegistosVendas.Contains(registo))
            {
                return false;
            }
            this.RegistosVendas.Add(registo);
            return true;
        }

        public string RelatorioVendas(int mes)
        {
            double totalVendas = 0;
            for (int i = 0; i < this.RegistosVendas.Count; i++)
            {
                if (this.RegistosVendas[i].Data.Month == mes)
                {
                    totalVendas += this.RegistosVendas[i].Valor;
                }
            }
            return $"Total de vendas no mês {mes}: {totalVendas}";
        }

        public List<double> GetValorVendas()
        {
            this.RegistosVendas.Sort(new SortByRegistoVenda());
            List<double> valores = new List<double>();
            for (int i = 0; i < this.RegistosVendas.Count; i++)
            {
                valores.Add(this.RegistosVendas[i].Valor);
            }
            return valores;
        }

        private class RegistoVenda
        {
            public DateOnly Data { get; set; }

            public double Valor { get; set; }

            public RegistoVenda(DateOnly data, double valor)
            {
                this.Data = data;
                this.Valor = valor;
            }

            public override bool Equals(object? obj)
            {
                // Check if the passed object is null or of a different type
                if (obj is not RegistoVenda other)
                    return false;

                // Compare properties for equality
                return this.Data == other.Data;
            }
        }

        private class SortByRegistoVenda : IComparer<RegistoVenda>
        {
            public int Compare(RegistoVenda? registo1, RegistoVenda? registo2)
            {
                if (registo1 == null || registo2 == null)
                {
                    return 0;
                }
                return registo1.Valor.CompareTo(registo2.Valor);
            }
        }
    }
}