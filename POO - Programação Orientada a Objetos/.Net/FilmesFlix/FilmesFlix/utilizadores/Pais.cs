using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.utilizadores
{
    public enum Pais
    {
        Portugal = 1,
        Brasil = 2,
        Espanha = 3,
        Franca = 4,
        Alemanha = 5,
        Italia = 6,
        ReinoUnido = 7,
        EstadosUnidos = 8,
        Canada = 9,
    }
    static class PaisExtensions
    {
        public static string GetDescription(this Pais pais)
        {
            switch (pais)
            {
                case Pais.Portugal:
                    return "Portugal";
                case Pais.Brasil:
                    return "Brasil";
                case Pais.Espanha:
                    return "Espanha";
                case Pais.Franca:
                    return "França";
                case Pais.Alemanha:
                    return "Alemanha";
                case Pais.Italia:
                    return "Itália";
                case Pais.ReinoUnido:
                    return "Reino Unido";
                case Pais.EstadosUnidos:
                    return "Estados Unidos";
                case Pais.Canada:
                    return "Canadá";
                default:
                    return "País não encontrado";
            }
        }
    }
}
