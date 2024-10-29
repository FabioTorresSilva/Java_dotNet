namespace CalculatorApp
{
    public class Calculator
    {
        public int Addition(int a, int b)
        {
            return a + b;
        }
        public int Subtraction(int a, int b)
        {
            return a - b;
        }
        public int Multiplication(int a, int b)
        {
            return a * b;
        }
        public int Division(int a, int b)
        {
            return a / b;
        }
        public bool IsPrime(int value)
        {
            int i = 2;
            if (value == 1)
            {
                return false;
            }
            while (i < value)
            {
                if (value % i == 0)
                {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}