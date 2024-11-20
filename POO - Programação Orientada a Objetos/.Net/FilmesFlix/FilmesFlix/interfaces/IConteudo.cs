using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.interfaces
{
    internal interface IConteudo
    {
        string Titulo { get; }
        int Ano { get; }
        string ClassificacaoEtariaDesc();
        string Resumo { get; }

    }
}
