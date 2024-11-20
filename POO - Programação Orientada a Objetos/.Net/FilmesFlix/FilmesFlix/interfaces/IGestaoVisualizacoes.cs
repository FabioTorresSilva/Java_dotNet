using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.interfaces
{
    internal interface IGestaoVisualizacoes
    {
        void AdicionarVisualizacao(Conteudo conteudo, int tempoVisualizacao);

        void AdicionarVisualizacao(Conteudo conteudo, int tempoVisualizacao, int temporada, int episodio);
    }
}
