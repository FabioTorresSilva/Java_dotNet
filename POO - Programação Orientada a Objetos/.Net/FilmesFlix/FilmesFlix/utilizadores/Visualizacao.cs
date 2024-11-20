using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FilmesFlix.conteudos;

namespace FilmesFlix.utilizadores
{
    public class Visualizacao
    {
        public Conteudo Conteudo { get; private set; }
        public DateTime Data { get; private set; }

        public Visualizacao(Conteudo conteudo)
        {
            Conteudo = conteudo;
            Data = DateTime.Now;
        }

        public override string ToString()
        {
            return $"Visualizado em: {Data}\n{Conteudo}";
        }

        public override bool Equals(object obj)
        {
            Visualizacao visualizacao = obj as Visualizacao;

            if (visualizacao == null)
            {
                return false;
            }

            return Conteudo.Equals(visualizacao.Conteudo) && Data.Equals(visualizacao.Data);
        }
    }
}
