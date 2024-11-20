using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace FilmesFlixTests.conteudos
{
    [TestClass]
    public class ConteudoTests
    {
        [TestMethod]
        public void AdicionarCategoria_ValidCategoria_CategoriaAdicionada()
        {
            // Arrange
            string categoria = "Ação";
            Conteudo conteudo = new FakeConteudo();

            // Act
            conteudo.AdicionarCategoria(categoria);

            // Assert
            Assert.AreEqual(1, conteudo.Categorias().Length);
            Assert.AreEqual(categoria, conteudo.Categorias()[0].Nome);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void AdicionarCategoria_DuplicateCategoria_ThrowsArgumentException()
        {
            // Arrange
            string categoria = "Ação";
            Conteudo conteudo = new FakeConteudo();
            conteudo.AdicionarCategoria(categoria);

            // Act
            conteudo.AdicionarCategoria(categoria);

            // Assert
            // Expects ArgumentException to be thrown
        }

        [TestMethod]
        public void RemoverCategoria_ValidCategoria_CategoriaRemovida()
        {
            // Arrange
            string categoria = "Ação";
            Conteudo conteudo = new FakeConteudo();
            conteudo.AdicionarCategoria(categoria);

            // Act
            conteudo.RemoverCategoria(categoria);

            // Assert
            Assert.AreEqual(0, conteudo.Categorias().Length);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void RemoverCategoria_InvalidCategoria_ThrowsArgumentException()
        {
            // Arrange
            string categoria = "Ação";
            Conteudo conteudo = new FakeConteudo();

            // Act
            conteudo.RemoverCategoria(categoria);

            // Assert
            // Expects ArgumentException to be thrown
        }

        private class FakeConteudo : Conteudo
        {
            public FakeConteudo() : base("Fake Conteudo", 2022, "Fake Resumo")
            {
            }
        }
    }
}
