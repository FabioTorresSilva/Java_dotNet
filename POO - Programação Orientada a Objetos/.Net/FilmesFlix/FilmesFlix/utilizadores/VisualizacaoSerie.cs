using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.utilizadores
{
    public class VisualizacaoSerie : VisualizacaoFilme
    {
        public int Temporada { get; set; }
        public int Episodio { get; set; }

        public VisualizacaoSerie(Conteudo conteudo, int tempoVisualizacao, int temporada, int episodio) : base(conteudo, tempoVisualizacao)
        {
            Temporada = temporada;
            Episodio = episodio;
        }
    }
}
