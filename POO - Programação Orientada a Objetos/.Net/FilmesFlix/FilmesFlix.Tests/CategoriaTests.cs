using FilmesFlix.conteudos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.Tests
{
    [TestClass]
    public class CategoriaTests
    {
        [TestMethod]
        public void Categoria_Constructor_DefaultValues()
        {
            // Arrange
            Categoria categoria;

            // Act
            categoria = new Categoria();

            // Assert
            Assert.AreEqual(1, categoria.Id);
            Assert.AreEqual("", categoria.Nome);
            Assert.AreEqual(Categoria.Tipo.Conteudo, categoria.tipo);
        }

        [TestMethod]
        public void Categoria_Constructor_WithName()
        {
            // Arrange
            Categoria categoria;
            string nome = "Action";

            // Act
            categoria = new Categoria(nome);

            // Assert
            Assert.AreEqual(2, categoria.Id);
            Assert.AreEqual(nome, categoria.Nome);
            Assert.AreEqual(Categoria.Tipo.Conteudo, categoria.tipo);
        }

        [TestMethod]
        public void Categoria_Constructor_WithNameAndType()
        {
            // Arrange
            Categoria categoria;
            string nome = "Drama";
            Categoria.Tipo tipo = Categoria.Tipo.Categoria;

            // Act
            categoria = new Categoria(nome, tipo);

            // Assert
            Assert.AreEqual(3, categoria.Id);
            Assert.AreEqual(nome, categoria.Nome);
            Assert.AreEqual(tipo, categoria.tipo);
        }

        [TestMethod]
        public void Categoria_ToString_ReturnsCorrectString()
        {
            // Arrange
            Categoria categoria = new Categoria("Comedy");
            string expected = "Id: 8, Nome: Comedy";

            // Act
            string result = categoria.ToString();

            // Assert
            Assert.AreEqual(expected, result);

        }

        [TestMethod]
        public void Categoria_Equals_ReturnsTrueForEqualObjects()
        {
            // Arrange
            Categoria categoria1 = new Categoria("Horror");
            Categoria categoria2 = new Categoria("Horror");

            // Act
            bool result = categoria1.Equals(categoria2);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void Categoria_Equals_ReturnsFalseForDifferentObjects()
        {
            // Arrange
            Categoria categoria1 = new Categoria("Sci-Fi");
            Categoria categoria2 = new Categoria("Action");

            // Act
            bool result = categoria1.Equals(categoria2);

            // Assert
            Assert.IsFalse(result);
        }
    }
}
