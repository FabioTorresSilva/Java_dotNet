using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.conteudos
{
    public class Filme : Conteudo
    {
        public int Duracao { get; private set; }
        public Filme():base()
        {
            Duracao = 0;
        }
        
        public Filme(string titulo, int ano, ClassificacaoEtaria classificacao, string resumo, int duracao) : base(titulo, ano, classificacao, resumo)
        {
            Duracao = duracao;
        }

        public Filme(string titulo, int ano, string resumo, int duracao) : base(titulo, ano, resumo)
        {
            Duracao = duracao;
        }

        public override string ToString()
        {
            return base.ToString() + $"\nDuração: {Duracao} minutos";
        }

    }
}
