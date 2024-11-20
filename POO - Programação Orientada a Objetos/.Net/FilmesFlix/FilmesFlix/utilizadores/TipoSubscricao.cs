using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.utilizadores
{
    public enum TipoSubscricao
    {
        trial = 1,
        ativo = 2,
        inativo = 3
    }

    static class TipoSubscricaoExtensions
    {
        public static string GetDescription(this TipoSubscricao tipoSubscricao)
        {
            switch (tipoSubscricao)
            {
                case TipoSubscricao.trial:
                    return "Trial";
                case TipoSubscricao.ativo:
                    return "Ativo";
                case TipoSubscricao.inativo:
                    return "Inativo";
                default:
                    return "Tipo de subscricao não encontrada";
            }
        }
    }
}
