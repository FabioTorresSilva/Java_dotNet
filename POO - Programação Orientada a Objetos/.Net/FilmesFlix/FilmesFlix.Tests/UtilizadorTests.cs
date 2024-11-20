using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using FilmesFlix.utilizadores;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FilmesFlix.Tests
{
    [TestClass]
    public class UtilizadorTests
    {
        [TestMethod]
        public void AdicionarSubscricao_ShouldAddSubscription()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);
            // Act
            utilizador.AdicionarSubscricao();

            // Assert
            Assert.IsTrue(utilizador.SubscricaoAtiva());
        }

        [TestMethod]
        [ExpectedException(typeof(SubscricaoAindaAtivaException))]
        public void AdicionarSubscricao_ShouldThrowSubscricaoAindaAtivaException()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);

            // Act
            utilizador.AdicionarSubscricao();
            utilizador.AdicionarSubscricao();
        }

        [TestMethod]
        public void SubscricaoAtiva_ShouldReturnFalseWhenNoSubscription()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);

            // Act
            bool subscricaoAtiva = utilizador.SubscricaoAtiva();

            // Assert
            Assert.IsFalse(subscricaoAtiva);
        }

        [TestMethod]
        public void SubscricaoAtiva_ShouldReturnTrueWhenSubscriptionIsActive()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);

            // Act
            bool subscricaoAtiva = utilizador.SubscricaoAtiva();

            // Assert
            Assert.IsTrue(subscricaoAtiva);
        }

        [TestMethod]
        public void GetTipoSubscricao_ShouldReturnInativoWhenNoSubscription()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);

            // Act
            TipoSubscricao tipoSubscricao = utilizador.GetTipoSubscricao();

            // Assert
            Assert.AreEqual(TipoSubscricao.inativo, tipoSubscricao);
        }

        [TestMethod]
        public void GetTipoSubscricao_ShouldReturnAtivoWhenSubscriptionIsActive()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);

            // Act
            TipoSubscricao tipoSubscricao = utilizador.GetTipoSubscricao();

            // Assert
            Assert.AreEqual(TipoSubscricao.trial, tipoSubscricao);




        }

        [TestMethod]
        public void GetTipoSubscricao_ShouldReturnTrialWhenOnlyOneSubscription()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);

            // Act
            TipoSubscricao tipoSubscricao = utilizador.GetTipoSubscricao();

            // Assert
            Assert.AreEqual(TipoSubscricao.trial, tipoSubscricao);
        }

        [TestMethod]
        public void AdicionarFavorito_ShouldAddFavoriteContent()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            utilizador.AdicionarFavorito(filme);

            // Assert
            Assert.AreEqual(1, utilizador.DevolverFavoritos().Length);
            Assert.AreEqual(filme, utilizador.DevolverFavoritos()[0]);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void AdicionarFavorito_ShouldThrowArgumentExceptionWhenContentAlreadyExists()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            utilizador.AdicionarFavorito(filme);
            utilizador.AdicionarFavorito(filme);
        }

        [TestMethod]
        public void RemoverFavorito_ShouldRemoveFavoriteContent()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            utilizador.AdicionarFavorito(filme);

            // Act
            utilizador.RemoverFavorito(filme);

            // Assert
            Assert.AreEqual(0, utilizador.DevolverFavoritos().Length);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void RemoverFavorito_ShouldThrowArgumentExceptionWhenContentDoesNotExist()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            utilizador.RemoverFavorito(filme);
        }

        [TestMethod]
        public void DevolverFavoritos_ShouldReturnFavoriteContents()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme1 = new Filme("Movie1", 2020, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            Filme filme2 = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            utilizador.AdicionarFavorito(filme1);
            utilizador.AdicionarFavorito(filme2);

            // Act
            Conteudo[] favoritos = utilizador.DevolverFavoritos();

            // Assert
            Assert.AreEqual(2, favoritos.Length);
            Assert.AreEqual(filme1, favoritos[0]);
            Assert.AreEqual(filme2, favoritos[1]);
        }

        [TestMethod]
        public void AdicionarVisualizacao_ShouldAddMovieVisualizacao()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            // Act
            utilizador.AdicionarVisualizacao(filme, 60);

            // Assert
            Assert.AreEqual(1, utilizador.DevolverVisualizacoes().Length);
            Assert.IsInstanceOfType(utilizador.DevolverVisualizacoes()[0], typeof(VisualizacaoFilme));
        }

        [TestMethod]
        public void AdicionarVisualizacao_ShouldAddSerieVisualizacao()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Serie serie = new Serie("Series", 2021, ClassificacaoEtaria.Mais_18, "Resumo", 1, 20);
            // Act
            utilizador.AdicionarVisualizacao(serie, 60, 1, 1);

            // Assert
            Assert.AreEqual(1, utilizador.DevolverVisualizacoes().Length);
            Assert.IsInstanceOfType(utilizador.DevolverVisualizacoes()[0], typeof(VisualizacaoSerie));
        }

        [TestMethod]
        [ExpectedException(typeof(SubscricaoInativaException))]
        public void AdicionarVisualizacao_ShouldThrowSubscricaoInativaExceptionWhenSubscriptionIsInactive()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            utilizador.AdicionarVisualizacao(filme, 60);
        }

        [TestMethod]
        public void DevolverVisualizacao_ShouldReturnVisualizacaoForGivenContent()
        {
            // Arrange
            Utilizador utilizador = new Utilizador("John Doe", "john.doe@example.com", Pais.Portugal);
            Filme filme = new Filme("Movie", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            utilizador.AdicionarVisualizacao(filme, 60);

            // Act
            Visualizacao visualizacao = utilizador.DevolverVisualizacao(filme);

            // Assert
            Assert.IsNotNull(visualizacao);
            Assert.AreEqual(filme, visualizacao.Conteudo);
        }
    }
}
