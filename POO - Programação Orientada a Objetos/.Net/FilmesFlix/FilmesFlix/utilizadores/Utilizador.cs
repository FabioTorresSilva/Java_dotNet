using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using FilmesFlix.interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace FilmesFlix.utilizadores
{
    public class Utilizador : IGestaoFavoritos, IGestaoVisualizacoes
    {
        public string Nome { get; set; }

        public string Email { get; set; }
        public Pais Pais { get; set; }

        private List<DateTime> _subscricoes;

        private List<Favorito> _favoritos;

        private List<Visualizacao> _visualizacoes;

        public Utilizador()
        {
            _subscricoes = new List<DateTime>();
            _favoritos = new List<Favorito>();
            _visualizacoes = new List<Visualizacao>();
        }
        public Utilizador(string nome, string email, Pais pais, bool trial = true) : this()
        {
            Nome = nome;
            Email = email;
            Pais = pais;
            if (trial)
            {
                _subscricoes.Add(DateTime.Now.AddDays(15));
            }
        }

        public void AdicionarSubscricao()
        {
            if (_subscricoes.Count == 0)
            {
                _subscricoes.Add(DateTime.Now.AddDays(30)); 
                return; 
            }

            var lastSubscricao = _subscricoes.Last();
            var daysRemaining = (lastSubscricao - DateTime.Now).Days;

            if (daysRemaining < 3)
            {
                _subscricoes.Add(lastSubscricao.AddDays(30));
            }
            else
            {
                throw new SubscricaoAindaAtivaException("A subscrição já está ativa e não precisa ser renovada.");
            }


        }

        public bool SubscricaoAtiva()
        {
            if (_subscricoes.Count == 0)
            {
                return false;
            }
            return _subscricoes.Last() >= DateTime.Now;
        }

        public TipoSubscricao GetTipoSubscricao()
        {
            if (_subscricoes.Count == 0)
            {
                return TipoSubscricao.inativo;
            }

            if (_subscricoes.Count == 1)
            {
                return TipoSubscricao.trial;
            }

            if (_subscricoes.Last() >= DateTime.Now)
            {
                return TipoSubscricao.ativo;
            }

           

            return TipoSubscricao.inativo;
        }

        public void AdicionarFavorito(Conteudo conteudo)
        {
            Favorito favorito = new Favorito(conteudo);
            if (_favoritos.Contains(favorito))
            {
                throw new ArgumentException("Conteúdo já existe");
            }
            _favoritos.Add(favorito);
        }

        public void RemoverFavorito(Conteudo conteudo)
        {
            Favorito favorito = new Favorito(conteudo);
            if (!_favoritos.Remove(favorito))
            {
                throw new ArgumentException("Conteúdo não existe");
            }
        }

        public Conteudo[] DevolverFavoritos()
        {
            RemoverFavoritosAntigos();
            Conteudo[] conteudos = new Conteudo[_favoritos.Count];
            for (int i = 0; i < _favoritos.Count; i++)
            {
                //Os conteúdos com mais de 6 meses na lista de favoritos devem ser removidos automaticamente

                conteudos[i] = _favoritos[i].Conteudo;
            }
            return conteudos;

        }

        private void RemoverFavoritosAntigos()
        {
            for (int i = 0; i < _favoritos.Count; i++)
            {
                if (_favoritos[i].DataRegisto.AddMonths(6) < DateTime.Now)
                {
                    _favoritos.RemoveAt(i);
                }
            }
        }

        public override string ToString()
        {
            return $"Nome: {Nome}\nEmail: {Email}\nPais: {Pais}\nSubscricoes: {string.Join(", ", _subscricoes)}\nFavoritos: {string.Join(", ", _favoritos)}";
        }

        public override bool Equals(object? obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }

            return Email == ((Utilizador)obj).Email;
        }

        public void AdicionarVisualizacao(Conteudo conteudo, int tempoVisualizacao)
        {
            //verificar se a subscricao está ativa
            if (!SubscricaoAtiva())
            {
                throw new SubscricaoInativaException();
            }
            _visualizacoes.Add(new VisualizacaoFilme(conteudo, tempoVisualizacao));
        }

        public void AdicionarVisualizacao(Conteudo conteudo, int tempoVisualizacao, int temporada, int episodio)
        {
            if (!SubscricaoAtiva())
            {
                throw new SubscricaoInativaException();
            }
            _visualizacoes.Add(new VisualizacaoSerie(conteudo, tempoVisualizacao, temporada, episodio));
        }

        public Visualizacao DevolverVisualizacao(Conteudo conteudo)
        {
            foreach (Visualizacao visualizacao in _visualizacoes)
            {
                if (visualizacao.Conteudo == conteudo)
                {
                    return visualizacao;
                }
            }

            throw new ArgumentException("O conteúdo é inválido");
        }

        public Visualizacao[] DevolverVisualizacoes()
        {
            return _visualizacoes.ToArray();
        }

        class Favorito
        {
            public DateTime DataRegisto { get; set; }
            public Conteudo Conteudo { get; set; }

            public Favorito(Conteudo conteudo)
            {
                DataRegisto = DateTime.Now;
                Conteudo = conteudo;
            }

            public override string ToString()
            {
                return $"Data de registo: {DataRegisto}\nConteudo: {Conteudo}";
            }
            public override bool Equals(object? obj)
            {
                if (obj == null || GetType() != obj.GetType())
                {
                    return false;
                }

                return Conteudo == ((Favorito)obj).Conteudo;
            }
        }

    }
}
