using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using FilmesFlix.gestores;
using FilmesFlix.utilizadores;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace FilmesFlixTests.conteudos
{
    [TestClass]
    public class GestaoUtilizadoresTests
    {
        [TestMethod]
        public void Adicionar_UtilizadorNaoExiste_AdicionaUtilizador()
        {
            // Arrange
            GestaoUtilizadores gestaoUtilizadores = new GestaoUtilizadores();
            Utilizador utilizador = new Utilizador("Nome", "Email", Pais.Italia);

            // Act
            gestaoUtilizadores.Adicionar(utilizador);

            // Assert
            Assert.IsTrue(gestaoUtilizadores.Utilizadores().Contains(utilizador));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void Adicionar_UtilizadorJaExiste_LancaArgumentException()
        {
            // Arrange
            GestaoUtilizadores gestaoUtilizadores = new GestaoUtilizadores();
            Utilizador utilizador = new Utilizador("Nome", "Email", Pais.Italia);
            gestaoUtilizadores.Adicionar(utilizador);

            // Act
            gestaoUtilizadores.Adicionar(utilizador);
        }

        [TestMethod]
        public void Remover_UtilizadorExiste_RemoveUtilizador()
        {
            // Arrange
            GestaoUtilizadores gestaoUtilizadores = new GestaoUtilizadores();
            Utilizador utilizador = new Utilizador("Nome", "Email@gmail.com", Pais.Italia);
            gestaoUtilizadores.Adicionar(utilizador);

            // Act
            gestaoUtilizadores.Remover("Email@gmail.com");

            // Assert
            Assert.IsFalse(gestaoUtilizadores.Utilizadores().Contains(utilizador));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void Remover_UtilizadorNaoExiste_LancaArgumentException()
        {
            // Arrange
            GestaoUtilizadores gestaoUtilizadores = new GestaoUtilizadores();

            // Act
            gestaoUtilizadores.Remover("test@example.com");
        }

    }
}
