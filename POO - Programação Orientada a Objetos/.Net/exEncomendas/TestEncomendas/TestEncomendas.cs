using exEncomendas;

namespace TestEncomendas
{
    [TestClass]
    public class TestEncomendas
    {
        [TestMethod]
        public void AdicionarProduto_DeveAdicionarProdutoALista()
        {
            // Arrange
            var cliente = new Cliente("João", false);
            var encomenda = new Encomenda(cliente);
            var produto = new Produto("Computador", 1000m);
            // Act
            encomenda.AdicionarProduto(produto);
            // Assert
            Assert.AreEqual(1, encomenda.Produtos.Count);
           
        }
        [TestMethod]
        public void CalcularTotal_DeveRetornarTotalSemDesconto()
        {
            // Arrange
            var cliente = new Cliente("João", false);
            var encomenda = new Encomenda(cliente);
            var produto1 = new Produto("Computador", 1000m);
            var produto2 = new Produto("Teclado", 50m);
            encomenda.AdicionarProduto(produto1);
            encomenda.AdicionarProduto(produto2);
            // Act
            var total = encomenda.CalcularTotal();
            // Assert
            Assert.AreEqual(1050m, total);
        }
        [TestMethod]
        public void CalcularTotal_DeveRetornarTotalComDesconto()
        {
            // Arrange
            var cliente = new Cliente("João", true);
            var encomenda = new Encomenda(cliente);
            var produto1 = new Produto("Computador", 1000m);
            var produto2 = new Produto("Teclado", 50m);
            encomenda.AdicionarProduto(produto1);
            encomenda.AdicionarProduto(produto2);
            // Act
            var total = encomenda.CalcularTotal();
            // Assert
            Assert.AreEqual(945m, total);
        }

    }
}