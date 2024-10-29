using ficha7;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ficha7.interfaces;

namespace FichaPratica7
{
    public class HiperMercado : SuperMercado, IHiperMercado
    {
        public int NumeroDepartamentos { get; set; }
        public HiperMercado(string nome, string localizacao, int numeroFuncionarios, int numeroCorredores, float precoCafe, int numeroDepartamentos) : base(nome, localizacao, numeroFuncionarios, numeroCorredores, precoCafe)
        {
            NumeroDepartamentos = numeroDepartamentos;
        }

        public float GetPrecoCombustivel(string tipoCombustivel)
        {
            switch (tipoCombustivel)
            {
                case "G":
                    return 1.5f;
                case "D":
                    return 1.2f;
                default:
                    return 0;
            }
        }
    }
}
