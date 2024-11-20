using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.interfaces
{
    internal interface ICategoryManager
    {
        void AdicionarCategoria(string categoria);

        void RemoverCategoria(string categoria);
        Categoria[] Categorias();


    }
}
