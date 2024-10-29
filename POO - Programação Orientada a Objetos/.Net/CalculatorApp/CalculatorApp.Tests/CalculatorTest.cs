namespace CalculatorApp.Tests
{
    [TestClass] // This attribute is necessary to identify the class as a test class
    public class CalculatorTest
    {
        [TestMethod] // This attribute is necessary to identify the method as a test method
        public void Test_Add()
        {
            var calc = new Calculator(); // Arrange - Create an instance of the class to be tested
            var result = calc.Addition(1, 2); // Act - Call the method to be tested
            Assert.AreEqual(3, result); // Assert - Check if the result is as expected
        }
        [TestMethod]
        public void Test_Subtract()
        {
            var calc = new Calculator(); // Arrange
            var result = calc.Subtraction(1, 2); // Act
            Assert.AreEqual(-1, result); // Assert
        }
        [TestMethod]
        public void Test_Multiply()
        {
            var calc = new Calculator(); // Arrange
            var result = calc.Multiplication(1, 2); // Act
            Assert.AreEqual(2, result); // Assert
        }
        [TestMethod]
        public void Test_Divide()
        {
            var calc = new Calculator(); // Arrange
            var result = calc.Division(4, 2); // Act
            Assert.AreEqual(2, result); // Assert
        }
        [TestMethod]
        [DataRow(1, false)] // This attribute is necessary to pass parameters to the test method
        [DataRow(2, true)]
        [DataRow(3, true)]
        [DataRow(4, false)]
        [DataRow(5, true)]
        [DataRow(6, false)]
        [DataRow(7, true)]
        [DataRow(8, false)]
        public void Test_IsPrime(int value, bool expected)
        {
            var calc = new Calculator(); // Arrange
            var result = calc.IsPrime(value); // Act
            Assert.AreEqual(result, expected); // Assert
        }
    }
}