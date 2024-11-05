namespace FichaPratica7.Test {
    [TestClass]
    public class CafeTests {

        [TestMethod]
        public void GerarChave_DeveRetornarStringDeSeteValores() {
            // Arrange
            var cafe = new Cafe("Café Central", "Centro", 5, 10, 0.8f);

            // Act
            var chave = cafe.GerarChave();

            // Assert
            Assert.IsNotNull(chave);
            Assert.AreEqual(7, chave.Split(' ', StringSplitOptions.RemoveEmptyEntries).Length);
        }

        [TestMethod]
        public void NumeroMesas_DeveRetornarNumeroCorreto() {
            // Arrange
            var cafe = new Cafe("Café Central", "Centro", 5, 10, 0.8f);

            // Act & Assert
            Assert.AreEqual(10, cafe.NumeroMesas);
        }

        [TestMethod]
        public void PrecoCafe_DeveRetornarPrecoCorreto() {
            // Arrange
            var cafe = new Cafe("Café Central", "Centro", 5, 10, 0.8f);

            // Act & Assert
            Assert.AreEqual(0.8f, cafe.PrecoCafe);
        }
    }
}
