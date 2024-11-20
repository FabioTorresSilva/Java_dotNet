using FilmesFlix.conteudos;
using FilmesFlix.exceptions;
using FilmesFlix.gestores;
using FilmesFlix.utilizadores;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace FilmesFlixTests.conteudos
{
    [TestClass]
    public class SistemaTests
    {


        [TestMethod]
        public void AdicionarUtilizador_ValidParameters_AddsUtilizador()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            string nome = "John Doe";
            string email = "john.doe@example.com";
            Pais pais = Pais.Portugal;

            // Act
            _sistema.AdicionarUtilizador(nome, email, pais);

            // Assert
            Assert.IsTrue(_sistema.DevolverUtilizadores().Any(u => u.Nome == nome && u.Email == email && u.Pais == pais));
        }

        [TestMethod]
        public void RemoverUtilizador_ExistingEmail_RemovesUtilizador()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);

            // Act
            _sistema.RemoverUtilizador(email);

            // Assert
            Assert.IsFalse(_sistema.DevolverUtilizadores().Any(u => u.Email == email));
        }

        [TestMethod]
        public void RenovarSubscricao_ExistingEmail_RenewsSubscricao()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal, false);

            // Act
            _sistema.RenovarSubscricao(email);

            // Assert
            Utilizador utilizador = _sistema.DevolverUtilizadores().FirstOrDefault(u => u.Email == email);
            Assert.IsNotNull(utilizador);
            Assert.IsTrue(utilizador.SubscricaoAtiva());
        }

        [TestMethod]
        public void AdicionarHistoricoVisualizacao_ValidParameters_AddsHistoricoVisualizacao()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            int tempoVisualizacao = 60;

            // Act
            _sistema.AdicionarHistoricoVisualizacao(email, conteudo, tempoVisualizacao);

            // Assert
            Utilizador utilizador = _sistema.DevolverUtilizadores().FirstOrDefault(u => u.Email == email);
            Assert.IsNotNull(utilizador);
            Assert.IsTrue(utilizador.DevolverVisualizacoes().Any(hv => hv.Conteudo == conteudo));
        }

        [TestMethod]
        public void ContinuarVisualizacao_ExistingConteudoAndUtilizador_ReturnsVisualizacao()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            int tempoVisualizacao = 60;
            _sistema.AdicionarHistoricoVisualizacao(email, conteudo, tempoVisualizacao);

            // Act
            Visualizacao visualizacao = _sistema.ContinuarVisualizacao(conteudo, _sistema.DevolverUtilizadores().FirstOrDefault(u => u.Email == email));

            // Assert
            Assert.IsNotNull(visualizacao);
            Assert.AreEqual(conteudo, visualizacao.Conteudo);
        }

        [TestMethod]
        public void AdicionarFavorito_ExistingEmailAndConteudo_AddsFavorito()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            // Act
            _sistema.AdicionarFavorito(email, conteudo);

            // Assert
            Utilizador utilizador = _sistema.DevolverUtilizadores().FirstOrDefault(u => u.Email == email);
            Assert.IsNotNull(utilizador);
            Assert.IsTrue(utilizador.DevolverFavoritos().Contains(conteudo));
        }

        [TestMethod]
        public void RemoverFavorito_ExistingEmailAndConteudo_RemovesFavorito()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            _sistema.AdicionarFavorito(email, conteudo);

            // Act
            _sistema.RemoverFavorito(email, conteudo);

            // Assert
            Utilizador utilizador = _sistema.DevolverUtilizadores().FirstOrDefault(u => u.Email == email);
            Assert.IsNotNull(utilizador);
            Assert.IsFalse(utilizador.DevolverFavoritos().Contains(conteudo));
        }

        [TestMethod]
        public void DevolverFavoritos_ExistingEmail_ReturnsFavoritos()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            string email = "john.doe@example.com";
            _sistema.AdicionarUtilizador("John Doe", email, Pais.Portugal);
            Conteudo conteudo1 = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            Conteudo conteudo2 = new Filme("Filme 2", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            _sistema.AdicionarFavorito(email, conteudo1);
            _sistema.AdicionarFavorito(email, conteudo2);

            // Act
            Conteudo[] favoritos = _sistema.DevolverFavoritos(email);

            // Assert
            Assert.IsNotNull(favoritos);
            Assert.AreEqual(2, favoritos.Length);
            Assert.IsTrue(favoritos.Contains(conteudo1));
            Assert.IsTrue(favoritos.Contains(conteudo2));
        }

        [TestMethod]
        public void AdicionarConteudo_ValidParameters_AddsConteudo()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);


            // Act
            _sistema.AdicionarConteudo(conteudo);

            // Assert
            Assert.IsTrue(_sistema.DevolverConteudos().Contains(conteudo));
        }

        [TestMethod]
        public void RemoverConteudo_ExistingConteudo_RemovesConteudo()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            _sistema.AdicionarConteudo(conteudo);

            // Act
            _sistema.RemoverConteudo(conteudo);

            // Assert
            Assert.IsFalse(_sistema.DevolverConteudos().Contains(conteudo));
        }

        [TestMethod]
        public void DevolverConteudoPorTitulo_ExistingTitulo_ReturnsConteudo()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            _sistema.AdicionarConteudo(conteudo);

            // Act
            Conteudo result = _sistema.DevolverConteudoPorTitulo("Filme 1");

            // Assert
            Assert.AreEqual(conteudo, result);
        }

        [TestMethod]
        public void DevolverConteudosPorCategoria_ExistingCategoria_ReturnsConteudos()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            Conteudo conteudo1 = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            Conteudo conteudo2 = new Filme("Filme 2", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);


            _sistema.AdicionarConteudo(conteudo1);
            _sistema.AdicionarConteudo(conteudo2);
            _sistema.AdicionarCategoriaAoConteudo(conteudo1.Titulo, "Action");
            _sistema.AdicionarCategoriaAoConteudo(conteudo2.Titulo, "Action");

            // Act
            Conteudo[] result = _sistema.DevolverConteudosPorCategoria("Action");

            // Assert
            Assert.IsNotNull(result);
            Assert.AreEqual(2, result.Length);
            Assert.IsTrue(result.Contains(conteudo1));
            Assert.IsTrue(result.Contains(conteudo2));
        }

        [TestMethod]
        public void DevolverConteudosPorTipo_ExistingTipo_ReturnsConteudos()
        {
            // Arrange
            Sistema _sistema = new Sistema();

            Conteudo conteudo1 = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);

            Conteudo conteudo2 = new Serie("Series", 2021, ClassificacaoEtaria.Mais_18, "Resumo", 1, 20);
            _sistema.AdicionarConteudo(conteudo1);
            _sistema.AdicionarConteudo(conteudo2);

            // Act
            Conteudo[] result = _sistema.DevolverConteudosPorTipo(typeof(Filme));

            // Assert
            Assert.IsNotNull(result);
            Assert.AreEqual(1, result.Length);
            Assert.AreEqual(conteudo1, result[0]);
        }

        [TestMethod]
        public void AdicionarCategoriaAoConteudo_ExistingConteudoAndCategoria_AddsCategoria()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            string categoria = "Thriller";

            _sistema.AdicionarConteudo(conteudo);
            // Act
            _sistema.AdicionarCategoriaAoConteudo(conteudo.Titulo, categoria);

            // Assert
            foreach (Categoria c in conteudo.Categorias())
            {
                if (c.Nome == categoria)
                {
                    Assert.IsTrue(true);
                }
            }

        }

        [TestMethod]
        public void RemoverCategoriaDeConteudo_ExistingConteudoAndCategoria_RemovesCategoria()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            string categoria = "Thriller";
            string categoria2 = "Action";
            conteudo.AdicionarCategoria(categoria);
            conteudo.AdicionarCategoria(categoria2);

            _sistema.AdicionarConteudo(conteudo);

            // Act
            _sistema.RemoverCategoriaDeConteudo(conteudo.Titulo, categoria);

            // Assert
            Assert.IsFalse(conteudo.Categorias().Last<Categoria>().Equals(categoria));
        }

        [TestMethod]
        public void GuardarUtilizadores_CallsGestaoUtilizadoresGuardar()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Sistema novoSistema = new Sistema();

            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            _sistema.AdicionarUtilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);
            _sistema.AdicionarConteudo(conteudo);
            // Act
            _sistema.GuardarUtilizadores();
            novoSistema.CarregarUtilizadores();

            // Assert
            // Verify that the GestaoUtilizadores.Guardar method was called
            Assert.AreEqual(_sistema.DevolverUtilizadores().Length, novoSistema.DevolverUtilizadores().Length);
        }



        [TestMethod]
        public void GuardarConteudos_CallsGestaoConteudosGuardar()
        {
            // Arrange
            Sistema _sistema = new Sistema();
            Sistema novoSistema = new Sistema();

            Conteudo conteudo = new Filme("Filme 1", 2021, ClassificacaoEtaria.Mais_18, "Reumo", 90);
            _sistema.AdicionarUtilizador("John Doe", "john.doe@example.com", Pais.Portugal, false);
            _sistema.AdicionarConteudo(conteudo);
            // Act
            _sistema.GuardarConteudos();
            novoSistema.CarregarConteudos();

            // Assert
            // Verify that the GestaoUtilizadores.Guardar method was called
            Assert.AreEqual(_sistema.DevolverConteudos().Length, novoSistema.DevolverConteudos().Length);
        }


    }
}
