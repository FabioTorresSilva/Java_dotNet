namespace FichaPratica7.Test {
    [TestClass]
    public class HiperMercadoTests {
        [TestMethod]
        public void NumeroDepartamentos_DeveRetornarNumeroCorreto() {
            // Arrange
            var hipermercado = new HiperMercado("Hiper", "Centro", 20, 8, 1.2f, 10);

            // Act & Assert
            Assert.AreEqual(10, hipermercado.NumeroDepartamentos);
        }

        [TestMethod]
        [DataRow("G", 1.5f)]
        [DataRow("D", 1.2f)]
        [DataRow("E", 0.0f)]
        public void GetPrecoCombustivel_DeveRetornarPrecoCorreto(String tipoCombustivel, float precoEsperado) {
            // Arrange
            var hipermercado = new HiperMercado("Hiper", "Centro", 20, 8, 1.2f, 10);

            // Act & Assert
            Assert.AreEqual(precoEsperado, hipermercado.GetPrecoCombustivel(tipoCombustivel));
        }
    }
}
