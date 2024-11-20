using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.utilizadores
{
    public class VisualizacaoFilme : Visualizacao
    {
        public int TempoVisualizacao { get; set; }

        public VisualizacaoFilme(Conteudo conteudo, int tempoVisualizacao) : base(conteudo)
        {
            TempoVisualizacao = tempoVisualizacao;
        }
    }
}
