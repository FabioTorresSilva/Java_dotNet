using ficha7;
using ficha7.interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FichaPratica7
{
    public class Cafe : Estabelecimento, ICafe
    {
        public int NumeroMesas { get; set; }

        public float PrecoCafe { get; }

        public Cafe(string nome, string localizacao, int numeroFuncionarios, int numeroMesas, float precoCafe) : base(nome, localizacao, numeroFuncionarios)
        {
            NumeroMesas = numeroMesas;
            PrecoCafe = precoCafe;
        }

        public string GerarChave()
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 7; i++)
            {
                sb.Append((new Random().Next(50)) + " ");
            }
            return sb.ToString();
        }



    }
}
