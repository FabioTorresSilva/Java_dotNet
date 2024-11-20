using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.conteudos
{
    public class Serie : Conteudo
    {
        public int Temporadas { get; private set; }
        public int Episodios { get; private set; }

        public Serie():base()
        {
            Temporadas = 0;
            Episodios = 0;
        }
     
        public Serie(string titulo, int ano, ClassificacaoEtaria classificacao, string resumo, int temporadas, int episodios) : base(titulo, ano, classificacao, resumo)
        {
            Temporadas = temporadas;
            Episodios = episodios;
        }

        public Serie(string titulo, int ano, string resumo, int temporadas, int episodios) : base(titulo, ano, resumo)
        {
            Temporadas = temporadas;
            Episodios = episodios;
        }

        public override string ToString()
        {
            return base.ToString() + $"\nTemporadas: {Temporadas}\nEpisódios: {Episodios}";
        }

    }
}
