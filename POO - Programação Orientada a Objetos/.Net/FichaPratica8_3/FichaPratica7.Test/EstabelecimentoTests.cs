namespace FichaPratica7.Test {
    [TestClass]
    public class EstabelecimentoTests {
        [TestMethod]
        public void RegistarVenda_DeveAdicionarVenda() {
            // Arrange
            var estabelecimento = new SuperMercado("Super", "Centro", 10, 5, 1.0f);
            var data = new DateOnly(2024, 1, 1);
            double valor = 100.0;

            // Act
            var resultado = estabelecimento.RegistarVenda(data, valor);

            // Assert
            Assert.IsTrue(resultado);
        }

        [TestMethod]
        public void RelatorioVendas_DeveRetornarTotalVendasParaOMes() {
            // Arrange
            var estabelecimento = new SuperMercado("Super", "Centro", 10, 5, 1.0f);
            estabelecimento.RegistarVenda(new DateOnly(2024, 1, 1), 100.0);
            estabelecimento.RegistarVenda(new DateOnly(2024, 1, 15), 50.0);

            // Act
            var relatorio = estabelecimento.RelatorioVendas(1);

            // Assert
            Assert.AreEqual("Total de vendas no mês 1: 150", relatorio);
        }

        [TestMethod]
        public void GetValorVendas_DeveRetornarListaDeValoresOrdenada() {
            // Arrange
            var estabelecimento = new SuperMercado("Super", "Centro", 10, 5, 1.0f);
            estabelecimento.RegistarVenda(new DateOnly(2024, 1, 1), 200.0);
            estabelecimento.RegistarVenda(new DateOnly(2024, 1, 2), 50.0);
            estabelecimento.RegistarVenda(new DateOnly(2024, 1, 3), 150.0);

            // Act
            var valores = estabelecimento.GetValorVendas();

            // Assert
            CollectionAssert.AreEqual(new List<double> { 50.0, 150.0, 200.0 }, valores);
        }
    }
}
