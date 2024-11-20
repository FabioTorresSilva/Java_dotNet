using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.interfaces
{
    internal interface IGestaoFavoritos
    {
        void AdicionarFavorito(Conteudo conteudo);

        void RemoverFavorito(Conteudo conteudo);

        Conteudo[] DevolverFavoritos();
    }
}
