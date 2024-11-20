using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using FilmesFlix.conteudos;
using FilmesFlix.utilizadores;

namespace FilmesFlix.gestores
{
    public class GestaoUtilizadores
    {
        private List<Utilizador> _utilizadores;

        public GestaoUtilizadores()
        {
            _utilizadores = new List<Utilizador>();
        }

        public void Adicionar(Utilizador utilizador)
        {
            if (_utilizadores.Contains(utilizador))
            {
                throw new ArgumentException("Utilizador já existe");
            }
            _utilizadores.Add(utilizador);
        }

        public void Remover(string email)
        {
            if(_utilizadores.Find(u => u.Email == email) is not Utilizador utilizador)
            {
                throw new ArgumentException("Utilizador não existe");
            }

            foreach (Utilizador ut in _utilizadores)
            {
                if (utilizador.Email == email)
                {
                    _utilizadores.Remove(utilizador);
                    return;
                }

            }
        }

        public Utilizador[] Utilizadores()
        {
            return _utilizadores.ToArray();
        }

        public void RenovarSubscricao(string email)
        {
            Utilizador? utilizador = _utilizadores.Find(u => u.Email == email);
            if (utilizador == null)
            {
                throw new ArgumentException("Utilizador não existe");
            }
            utilizador.AdicionarSubscricao();
        }

        public void AdicionarVisualizacao(string email, Conteudo conteudo, int tempoVisualizacao, int temporada = 0, int numeroEpisodios = 0)
        {
            if(_utilizadores.Find(u => u.Email == email) is not Utilizador utilizador)
            {
                throw new ArgumentException("Utilizador não existe");
            }
            if (!_utilizadores.Contains(utilizador))
            {
                throw new ArgumentException("Utilizador não existe");
            }
            if (conteudo is Serie)
            {
                if (temporada <= 0 || numeroEpisodios <= 0)
                {
                    throw new ArgumentException("Temporada e número de episódios devem ser especificados para séries.");
                }
                // Lógica para adicionar visualização de série
                utilizador.AdicionarVisualizacao(conteudo, tempoVisualizacao, temporada, numeroEpisodios);
            }
            else if (conteudo is Filme)
            {
                // Lógica para adicionar visualização de filme
                utilizador.AdicionarVisualizacao(conteudo, tempoVisualizacao);
            }
            else
            {
                throw new ArgumentException("Tipo de conteúdo desconhecido.");
            }
        }

        public Visualizacao ContinuarVisualizacao(Conteudo conteudo, Utilizador utilizador)
        {
            return utilizador.DevolverVisualizacao(conteudo);
        }

        public void AdicionarFavorito(string email, Conteudo conteudo)
        {

            if(_utilizadores.Find(u => u.Email == email) is not Utilizador utilizador)
            {
                throw new ArgumentException("Utilizador não existe");
            }
            utilizador.AdicionarFavorito(conteudo);
        }

        public void RemoverFavorito(string email, Conteudo conteudo)
        {
            if (_utilizadores.Find(u => u.Email == email) is not Utilizador utilizador)
            {
                throw new ArgumentException("Utilizador não existe");
            }
            utilizador.RemoverFavorito(conteudo);
        }

        public Conteudo[] DevolverFavoritos(string email)
        {
            if (_utilizadores.Find(u => u.Email == email) is not Utilizador utilizador)
            {
                throw new ArgumentException("Utilizador não existe");
            }
            return utilizador.DevolverFavoritos();
        }

        public void Guardar()
        {
            FileHandler.Save("utilizadores.txt", _utilizadores);
        }

        public void Carregar()
        {
            string jsonString = FileHandler.Load("utilizadores.txt");
            using (JsonDocument doc = JsonDocument.Parse(jsonString))
            {
                _utilizadores = JsonSerializer.Deserialize<List<Utilizador>>(doc.RootElement.GetRawText());
            }
        }
    }
}
