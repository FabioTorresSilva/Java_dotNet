namespace FichaPratica7.Test
{
    [TestClass]
    [DeploymentItem(@"C:\classLevelDepItem.xml")]   // Copy file using some absolute path

    public class SuperMercadoTests
    {
        [TestMethod]
        public void NumeroCorredores_DeveRetornarNumeroCorreto()
        {
            // Arrange
            var supermercado = new SuperMercado("Super", "Centro", 10, 5, 1.0f);

            // Act & Assert
            Assert.AreEqual(5, supermercado.NumeroCorredores);
        }

        [TestMethod]
        public void PrecoCafe_DeveRetornarPrecoCorreto()
        {
            // Arrange
            var supermercado = new SuperMercado("Super", "Centro", 10, 5, 1.0f);

            // Act & Assert
            Assert.AreEqual(1.0f, supermercado.PrecoCafe);
        }
    }
}
