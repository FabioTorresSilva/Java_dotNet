using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using FilmesFlix.gestores;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace FilmesFlixTests.conteudos
{
    [TestClass]
    public class GestaoConteudosTests
    {
        [TestMethod]
        public void AdicionarConteudo_DeveAdicionarConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            gestaoConteudos.AdicionarConteudo(conteudo);

            // Assert
            Assert.AreEqual(1, gestaoConteudos.DevolverConteudos().Length);
            Assert.AreEqual(conteudo, gestaoConteudos.DevolverConteudos()[0]);
        }

        [TestMethod]
        public void RemoverConteudo_DeveRemoverConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            gestaoConteudos.AdicionarConteudo(conteudo);

            // Act
            gestaoConteudos.RemoverConteudo(conteudo);

            // Assert
            Assert.AreEqual(0, gestaoConteudos.DevolverConteudos().Length);
        }

        [TestMethod]
        public void DevolverConteudoPorTitulo_DeveDevolverConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo1 = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            Conteudo conteudo2 = new Filme("Filme 2", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            gestaoConteudos.AdicionarConteudo(conteudo1);
            gestaoConteudos.AdicionarConteudo(conteudo2);

            // Act
            Conteudo resultado = gestaoConteudos.DevolverConteudoPorTitulo("Filme 1");

            // Assert
            Assert.AreEqual(conteudo1, resultado);
        }

        [TestMethod]
        public void DevolverConteudoPorTitulo_DeveLancarExcecaoQuandoConteudoNaoEncontrado()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo1 = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            gestaoConteudos.AdicionarConteudo(conteudo1);

            // Act & Assert
            Assert.ThrowsException<ArgumentException>(() => gestaoConteudos.DevolverConteudoPorTitulo("Filme 2"));
        }

        [TestMethod]
        public void DevolverConteudoPorCategoria_DeveDevolverConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo1 = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            Conteudo conteudo2 = new Serie("Series", 2021, ClassificacaoEtaria.Mais_18, "Resumo", 1, 20);
            conteudo1.AdicionarCategoria("Ação");
            conteudo2.AdicionarCategoria("Ação");
            gestaoConteudos.AdicionarConteudo(conteudo1);
            gestaoConteudos.AdicionarConteudo(conteudo2);

            // Act
            Conteudo[] resultado = gestaoConteudos.DevolverConteudoPorCategoria("Ação");

            // Assert
            Assert.AreEqual(2, resultado.Length);
            CollectionAssert.Contains(resultado, conteudo1);
            CollectionAssert.Contains(resultado, conteudo2);
        }

        [TestMethod]
        public void DevolverConteudoPorTipo_DeveDevolverConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo1 = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            Conteudo conteudo2 = new Serie("Series", 2021, ClassificacaoEtaria.Mais_18, "Resumo", 1, 20);
            gestaoConteudos.AdicionarConteudo(conteudo1);
            gestaoConteudos.AdicionarConteudo(conteudo2);

            // Act
            Conteudo[] resultado = gestaoConteudos.DevolverConteudoPorTipo(typeof(Filme));

            // Assert
            Assert.AreEqual(1, resultado.Length);
            Assert.AreEqual(conteudo1, resultado[0]);
        }

        [TestMethod]
        public void AdicionarCategoria_DeveAdicionarCategoriaAoConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            gestaoConteudos.AdicionarConteudo(conteudo);

            // Act
            gestaoConteudos.AdicionarCategoria(conteudo.Titulo, "Ação");

            // Assert
            Assert.AreEqual(1, conteudo.Categorias().Length);
            Assert.AreEqual("Ação", conteudo.Categorias()[0].Nome);
        }

        [TestMethod]
        public void RemoverCategoria_DeveRemoverCategoriaDoConteudo()
        {
            // Arrange
            GestaoConteudos gestaoConteudos = new GestaoConteudos();
            Conteudo conteudo = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            conteudo.AdicionarCategoria("Ação");
            gestaoConteudos.AdicionarConteudo(conteudo);

            // Act
            gestaoConteudos.RemoverCategoria(conteudo.Titulo, "Ação");

            // Assert
            Assert.AreEqual(0, conteudo.Categorias().Length);
        }
    }
}
