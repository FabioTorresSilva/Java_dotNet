using FilmesFlix.exceptions;
using FilmesFlix.interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace FilmesFlix.conteudos
{
    [JsonPolymorphic]
    [JsonDerivedType(typeof(Filme), nameof(Filme))]
    [JsonDerivedType(typeof(Serie), nameof(Serie))]
    public abstract class Conteudo : IConteudo, ICategoryManager
    {
        public string Titulo { get; protected set; }
        public int Ano { get; protected set; }

        public ClassificacaoEtaria Classificacao { get; protected set; }

        public string ClassificacaoEtariaDesc()
        {
            return Classificacao.GetDescription();
        }
        public string Resumo { get; protected set; }

        private List<Categoria> _categorias;

        public Conteudo()
        {
            _categorias = new List<Categoria>();
            Titulo = "";
            Resumo = "";
        }
        public Conteudo(string titulo, int ano, ClassificacaoEtaria classificacao, string resumo) : this()
        {
            Titulo = titulo;
            Ano = ano;
            Classificacao = classificacao;
            Resumo = resumo;
        }

        public Conteudo(string titulo, int ano, string resumo) : this()
        {
            Titulo = titulo;
            Ano = ano;
            Classificacao = ClassificacaoEtaria.Livre;
            Resumo = resumo;
        }

        public override string ToString()
        {
            return $"Título: {Titulo}\nAno: {Ano}\nClassificação: {Classificacao}\nResumo: {Resumo}";
        }

        public override bool Equals(object? obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            return Titulo == ((Conteudo)obj).Titulo;
        }

        public void AdicionarCategoria(string categoria)
        {
            Categoria novaCategoria = new Categoria(categoria);
            if (_categorias.IndexOf(novaCategoria) != -1)
            {
                throw new ArgumentException("Categoria já existe");
            }
            _categorias.Add(novaCategoria);
        }

        public void RemoverCategoria(string categoria)
        {
            Categoria novaCategoria = new Categoria(categoria);
            if (!_categorias.Remove(novaCategoria))
            {
                throw new ArgumentException("Categoria não existe");
            }
        }

        public Categoria[] Categorias()
        {
            return _categorias.ToArray();
        }


    }
}
