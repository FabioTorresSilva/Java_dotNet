using FilmesFlix.conteudos;
using FilmesFlix.utilizadores;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FilmesFlix.gestores
{
    public class GestaoConteudos
    {
        private List<Conteudo> _conteudos;

        public GestaoConteudos()
        {
            _conteudos = new List<Conteudo>();
        }

        public void AdicionarConteudo(Conteudo conteudo)
        {
            _conteudos.Add(conteudo);
        }

        public void RemoverConteudo(Conteudo conteudo)
        {
            _conteudos.Remove(conteudo);
        }

        public Conteudo[] DevolverConteudos()
        {
            return _conteudos.ToArray();
        }

        public Conteudo DevolverConteudoPorTitulo(string titulo)
        {
            foreach(Conteudo conteudo in _conteudos)
            {
                if (conteudo.Titulo == titulo)
                {
                    return conteudo;
                }
            }
            throw new ArgumentException("Conteudo não encontrado");
        }

        public Conteudo[] DevolverConteudoPorCategoria(string categoria)
        {
            string categoriaMinuscula = categoria.ToLower();
            List<Conteudo> conteudos = new List<Conteudo>();
            foreach(Conteudo conteudo in _conteudos)
            {
                foreach(Categoria c in conteudo.Categorias())
                {
                    if (c.Nome.ToLower() == categoriaMinuscula)
                    {
                        conteudos.Add(conteudo);
                    }
                }
            }
            return conteudos.ToArray();
        }

        public Conteudo[] DevolverConteudoPorTipo(Type tipo)
        {
            List<Conteudo> conteudos = new List<Conteudo>();
            foreach(Conteudo conteudo in _conteudos)
            {
                if(tipo.IsInstanceOfType(conteudo))
                {
                    conteudos.Add(conteudo);
                }
            }

            return conteudos.ToArray();
        }

        public void AdicionarCategoria(string titulo, string categoria)
        {
            Conteudo conteudo = DevolverConteudoPorTitulo(titulo);
            conteudo.AdicionarCategoria(categoria);
        }

        public void RemoverCategoria(string titulo, string categoria)
        {
            foreach(Conteudo c in _conteudos)
            {
                if (c.Titulo.Equals(titulo))
                {
                    c.RemoverCategoria(categoria);
                }
            }
        }

        public void Guardar()
        {
            var options = new JsonSerializerOptions
            {
                WriteIndented = true
            };
            string jsonString = JsonSerializer.Serialize(_conteudos, options);
            File.WriteAllText("conteudos.json", jsonString);
        }

        public void Carregar()
        {
            string jsonString = File.ReadAllText("conteudos.json");
            _conteudos = JsonSerializer.Deserialize<List<Conteudo>>(jsonString) ?? new List<Conteudo>();
        }
    }
}
