using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.conteudos
{
    public class Categoria
    {
        private static int Codigo = 1;

        public int Id { get; private set; }
        public string Nome { get; set; }
        public Tipo tipo { get; set; }

        public Categoria()
        {
            Id = Codigo++;
            Nome = "";
        }

        public Categoria(string nome)
        {
            Id = Codigo++;
            Nome = nome;
            tipo = Tipo.Conteudo;
        }

        public Categoria(string nome, Tipo tipo)
        {
            Id = Codigo++;
            Nome = nome;
            this.tipo = tipo;
        }
        public override string ToString()
        {
            return $"Id: {Id}, Nome: {Nome}";
        }

        public override bool Equals(object? obj)
        {
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }
            if (Nome == ((Categoria)obj).Nome)
            {
                return true;
            }
            return false;
        }
        public enum Tipo
        {
            Conteudo,
            Categoria
        }
    }
}
