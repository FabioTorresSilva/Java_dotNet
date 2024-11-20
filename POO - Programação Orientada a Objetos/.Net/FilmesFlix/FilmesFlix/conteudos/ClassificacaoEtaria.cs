using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.conteudos
{
    public enum ClassificacaoEtaria
    {
        Livre = 1,
        Mais_12 = 12,
        Mais_16 = 16,
        Mais_18 = 18
    }

    static class ClassificacaoEtariaExtensions
    {
        public static string GetDescription(this ClassificacaoEtaria classificacao)
        {
            switch (classificacao)
            {
                case ClassificacaoEtaria.Livre:
                    return "Livre";
                case ClassificacaoEtaria.Mais_12:
                    return "12+";
                case ClassificacaoEtaria.Mais_16:
                    return "16+";
                case ClassificacaoEtaria.Mais_18:
                    return "18+";
                default:
                    return "Classificação não encontrada";
            }
        }
    }
}
