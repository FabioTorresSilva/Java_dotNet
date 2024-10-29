using ficha7.interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ficha7;

namespace FichaPratica7
{
    public class SuperMercado : Estabelecimento, ISuperMercado
    {
        public int NumeroCorredores { get; set; }

        public float PrecoCafe { get; private set; } = 0.5f; 

        public SuperMercado(string nome, string localizacao, int numeroFuncionarios, int numeroCorredores, float precoCafe) : base(nome, localizacao, numeroFuncionarios)
        {
            NumeroCorredores = numeroCorredores;
            PrecoCafe = precoCafe;
        }

       

    }
}
