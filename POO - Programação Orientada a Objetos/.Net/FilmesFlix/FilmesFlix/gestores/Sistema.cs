using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.gestores
{
    using FilmesFlix.conteudos;
    using FilmesFlix.utilizadores;
    using System;
    using System.Collections.Generic;

    public class Sistema
    {
        private readonly GestaoUtilizadores _gestaoUtilizadores;
        private readonly GestaoConteudos _gestaoConteudos;

        public Sistema()
        {
            _gestaoUtilizadores = new GestaoUtilizadores();
            _gestaoConteudos = new GestaoConteudos();
        }

        // Métodos de gestão de utilizadores
        public void AdicionarUtilizador(string nome, string email, Pais pais, bool trial=true)
        {
            try
            {
                _gestaoUtilizadores.Adicionar(new Utilizador(nome,email, pais, trial));
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao adicionar utilizador: " + ex.Message);
            }
        }
        public void AdicionarUtilizador(Utilizador utilizador)
        {
            try
            {
                _gestaoUtilizadores.Adicionar(utilizador);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao adicionar utilizador: " + ex.Message);
            }
        }

        public void RemoverUtilizador(string email)
        {
            try
            {
                _gestaoUtilizadores.Remover(email);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao remover utilizador: " + ex.Message);
            }
        }

        public void RenovarSubscricao(string email)
        {
            try
            {
                _gestaoUtilizadores.RenovarSubscricao(email);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao renovar subscrição: " + ex.Message);
            }
        }

        public Utilizador[] DevolverUtilizadores()
        {
            return _gestaoUtilizadores.Utilizadores();
        }

        public void AdicionarHistoricoVisualizacao(string email, Conteudo conteudo, int tempoVisualizacao, int temporada = 0, int numeroEpisodios = 0)
        {
            try
            {
                _gestaoUtilizadores.AdicionarVisualizacao(email, conteudo, tempoVisualizacao, temporada, numeroEpisodios);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao adicionar histórico de visualização: " + ex.Message);
            }
        }

        public Visualizacao ContinuarVisualizacao(Conteudo conteudo, Utilizador utilizador)
        {
            try
            {
                return _gestaoUtilizadores.ContinuarVisualizacao(conteudo, utilizador);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao continuar visualização: " + ex.Message);
            }
        }

        public void AdicionarFavorito(string email, Conteudo conteudo)
        {
            try
            {
                _gestaoUtilizadores.AdicionarFavorito(email, conteudo);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao adicionar favorito: " + ex.Message);
            }
        }

        public void RemoverFavorito(string email, Conteudo conteudo)
        {
            try
            {
                _gestaoUtilizadores.RemoverFavorito(email, conteudo);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao remover favorito: " + ex.Message);
            }
        }

        public Conteudo[] DevolverFavoritos(string email)
        {
            try
            {
                return _gestaoUtilizadores.DevolverFavoritos(email);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao devolver favoritos: " + ex.Message);
            }
        }

        public void GuardarUtilizadores()
        {
            _gestaoUtilizadores.Guardar();
        }

        public void CarregarUtilizadores()
        {
            _gestaoUtilizadores.Carregar();
        }

        // Métodos de gestão de conteúdos
        public void AdicionarConteudo(Conteudo conteudo)
        {
            try
            {
                _gestaoConteudos.AdicionarConteudo(conteudo);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao adicionar conteúdo: " + ex.Message);
            }
        }

        public void RemoverConteudo(Conteudo conteudo)
        {
            try
            {
                _gestaoConteudos.RemoverConteudo(conteudo);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao remover conteúdo: " + ex.Message);
            }
        }

        public Conteudo DevolverConteudoPorTitulo(string titulo)
        {
            try
            {
                return _gestaoConteudos.DevolverConteudoPorTitulo(titulo);
            }
            catch (ArgumentException ex)
            {
                throw new InvalidOperationException("Erro ao devolver conteúdo por título: " + ex.Message);
            }
        }

        public Conteudo[] DevolverConteudosPorCategoria(string categoria)
        {
            return _gestaoConteudos.DevolverConteudoPorCategoria(categoria);
        }

        public Conteudo[] DevolverConteudosPorTipo(Type tipo)
        {
            return _gestaoConteudos.DevolverConteudoPorTipo(tipo);
        }

        public Conteudo[] DevolverConteudos()
        {
            return _gestaoConteudos.DevolverConteudos();
        }
        public void AdicionarCategoriaAoConteudo(string titulo, string categoria)
        {
            _gestaoConteudos.AdicionarCategoria(titulo, categoria);
        }

        public void RemoverCategoriaDeConteudo(string titulo, string categoria)
        {
            _gestaoConteudos.RemoverCategoria(titulo, categoria);
        }

        public void GuardarConteudos()
        {
            _gestaoConteudos.Guardar();
        }

        public void CarregarConteudos()
        {
            _gestaoConteudos.Carregar();
        }
    }

}
