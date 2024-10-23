using System.Collections;
using System.Text;

namespace Fundamentals {
    class Program {

        enum CarColor {
            Orange = 1,
            Blue,
            Green,
            Red,
            Yellow
        }

        static void Printing() {
            Console.WriteLine("Hello");
            Console.Write("World");
            Console.WriteLine("!");
        }

        static void Variables() {
            string name = "CSharp";         // String's are objects not primitives
            char classification = 'A';

            // short, int, long can be pre-pended with 'u' for 'unsigned'
            byte age0 = 0;                  // 8-bit unsigned integer
            short age1 = 10;                // 16-bit signed integer.
            int age2 = 20;                  // 32-bit signed integer
            long age3 = 30L;                // 64-bit signed integer

            float gpa0 = 2.5F;              // 32-bit floating point
            double gpa1 = 3.5;              // 64-bit double-precision floating point
            decimal gpa2 = 4.5M;            // 128-bit precise decimal

            bool allowed = true;            // 1 bit -> true/false

            Console.WriteLine("Your name is " + name);
            Console.WriteLine($"Your name is {name}");

            Console.WriteLine("Biggest Integer {0} and Smallest {1} ", int.MaxValue, int.MinValue);
        }

        static void CastingConversion() {

            // Cast integer into long (Implicit Conversion), smaller size type to a larger size
            int intNum = 10;
            long longNum = intNum;

            intNum = (int)longNum; // produces an error

            // Cast double into integer (Explicit Conversion)
            double dblNum = 12.345;
            Console.WriteLine($"Integer : {(int)dblNum}");

            // Converting
            int intFromString = Convert.ToInt32("50");
            double doubleFromString = Convert.ToDouble("50.99");

            Console.WriteLine(100 + intFromString);
            Console.WriteLine(100 + doubleFromString);

            // Parsing
            bool boolFromStr = bool.Parse("True");
            int intFromStr = int.Parse("100");
            double dblFromStr = double.Parse("1.234");

            Console.WriteLine($"Data type boolFromStr: {boolFromStr.GetType()}");
            Console.WriteLine($"Data type intFromStr: {intFromStr.GetType()}");
            Console.WriteLine($"Data type dblFromStr: {dblFromStr.GetType()}");

            // Convert double into a string
            string strVal = dblFromStr.ToString();
        }

        static void StringBuider() {
            StringBuilder sb = new StringBuilder();

            sb.Append("This is the first sentence. ");
            sb.AppendFormat("My name is {0} and I live in {1}", "Derek", "Pennsylvania");
            sb.Replace("a", "e");
            sb.Remove(5, 7);
            Console.WriteLine(sb.ToString());
        }

        static void FormartOutput() {
            // Format output for currency
            Console.WriteLine("Currency: {0:c}", 23.455);
            // Pad with zeroes
            Console.WriteLine("Pad with 0s: {0:d2}", 2);
            Console.WriteLine("Pad with 0s: {0:d2}", 20);
            // Define decimals
            Console.WriteLine("2 Decimals: {0:f2}", 23.4555);
            // Add commas and decimals
            Console.WriteLine("Commas: {0:n4}", 2300);
        }

        static void Strings() {
            string greeting = "            Hello!!           ";

            Console.WriteLine("|{0}|", greeting.TrimStart());
            Console.WriteLine("|{0}|", greeting.TrimEnd());

            Console.WriteLine("|{0}|", greeting);
            greeting = greeting.Trim();

            Console.WriteLine("|{0}|", greeting);

            Console.WriteLine(greeting.Length);
            Console.WriteLine(greeting[0]);

            Console.WriteLine(greeting.IndexOf("H"));
            Console.WriteLine(greeting.IndexOf("llo"));
            Console.WriteLine(greeting.IndexOf('z'));

            Console.WriteLine(greeting.Contains("ll"));

            Console.WriteLine(greeting.Substring(2));
            Console.WriteLine(greeting.Substring(1, 3));

            Console.WriteLine(greeting.ToUpper());
            Console.WriteLine(greeting.ToLower());

            Console.WriteLine(greeting.Remove(greeting.IndexOf("!"), 2));
            Console.WriteLine(greeting.Insert(greeting.IndexOf("!"), "!!"));
            Console.WriteLine(greeting.Replace("!!", "??"));

            Console.WriteLine(greeting.PadLeft(20, '.'));
            Console.WriteLine(greeting.PadRight(20, ' '));

            // Check if strings are equal
            Console.WriteLine("A = a : {0}", String.Equals("A", "a"));
            Console.WriteLine("A = a : {0}", String.Equals("A", "a", StringComparison.OrdinalIgnoreCase));

            // Compare strings and ignore case, result: < 0 : str1 preceeds str2, = : 0 > 0 : str2 preceeds str1
            Console.WriteLine("Compare A to B : {0}", String.Compare("A", "B", StringComparison.OrdinalIgnoreCase));

            // Use Format to create strings
            string newString = String.Format("{0} {1}", greeting.Remove(greeting.IndexOf("!"), 2), "Student");

            // You can add newlines with \n and join strings with +
            Console.Write(newString + "\n");

            // Other escape characters
            // \' \" \\ \t \a

            // Verbatim strings ignore escape characters
            Console.WriteLine("Exactly What I Typed\n");
        }

        static void Numbers() {
            Console.WriteLine(2 * 3);       // Basic Arithmetic: +, -, /, *
            Console.WriteLine(10 % 3);      // Modulus Op. : returns remainder of 10/3
            Console.WriteLine(1 + 2 * 3);   // order of operations
            Console.WriteLine(10 / 3.0);    // int's and doubles

            int num = 10;
            num += 100; // +=, -=, /=, *=
            Console.WriteLine(num);

            num++;
            Console.WriteLine(num);

            Console.WriteLine(Math.Pow(2, 3));
            Console.WriteLine(Math.Sqrt(144));
            Console.WriteLine(Math.Round(2.7));
        }

        static void UserInput() {
            Console.Write("Enter username: ");
            string username = Console.ReadLine();
            Console.WriteLine($"Hello {username}");
        }

        static void Arrays() {
            int[] luckyNumbers0 = new int[10];
            int[] luckyNumbers1 = { 4, 8, 15, 16, 23, 42 };
            var employees = new[] { "Xico", "Mike", "Paul", "Rick" };
            Console.WriteLine("randomArray 0 : {0}", employees[0].GetType());

            luckyNumbers1[0] = 90;
            Console.WriteLine(luckyNumbers1[0]);
            Console.WriteLine(luckyNumbers1[1]);
            Console.WriteLine(luckyNumbers1.Length);

            for (int i = 0; i < employees.Length; i++) {
                Console.WriteLine("index {0}: Name: {1}", i, employees[i]);
            }

            Array.Sort(employees);
            for (int i = 0; i < employees.Length; i++) {
                Console.WriteLine("index {0}: Name: {1}", i, employees[i]);
            }

            Array.Reverse(employees);
            for (int i = 0; i < employees.Length; i++) {
                Console.WriteLine("index {0}: Name: {1}", i, employees[i]);
            }

            Console.WriteLine("Xico at index : {0} ", Array.IndexOf(employees, "Xico"));

            int[] destArray = new int[luckyNumbers1.Length];
            Array.Copy(luckyNumbers1, 0, destArray, 0, destArray.Length);

            for (int i = 0; i < destArray.Length; i++) {
                Console.WriteLine("{0}", destArray[i]);
            }

            // N Dimensional Arrays

            int[,] numberGrid10 = new int[2, 3];
            int[,] numberGrid11 = { { 1, 2 }, { 3, 4 } };

            numberGrid11[0, 1] = 99;
            numberGrid11.SetValue(99, 0, 1);

            Console.WriteLine(numberGrid11[0, 0]);
            Console.WriteLine(numberGrid11[0, 1]);

            Console.WriteLine(numberGrid11.GetValue(0, 0));
            Console.WriteLine(numberGrid11.GetValue(0, 1));

            Console.WriteLine("---");
            for (int j = 0; j < numberGrid11.GetLength(0); j++) {
                for (int k = 0; k < numberGrid11.GetLength(1); k++) {
                    Console.Write("{0,5:d2}|", numberGrid11[j, k]);
                }
                Console.WriteLine();
            }
            Console.WriteLine("---");

            // jagged-array

            int[][] numberGrid20 = new int[2][];
            int[][] numberGrid21 = { new int[] { 1, 2 }, new int[] { 3, 4, 5 } };
            numberGrid21[0][1] = 99;

            Console.WriteLine(numberGrid21[0][0]);
            Console.WriteLine(numberGrid21[0][1]);

            Console.WriteLine(numberGrid21.Length);
            Console.WriteLine(numberGrid21[0].Length);
            Console.WriteLine(numberGrid21[1].Length);

            // ArrayList

            ArrayList friends = new ArrayList();
            friends.Add("Person2");
            friends.Add("Person1");
            friends.Add("Person3");

            friends.Remove("Person1");
            Console.WriteLine(friends[0]);
            Console.WriteLine(friends[1]);
            Console.WriteLine(friends.Contains("Person2"));
            Console.WriteLine(friends.Count);
        }

        static void Conditionals() {
            // if-else

            bool isStudent = false;
            bool isSmart = false;

            if (isStudent && isSmart) {
                Console.WriteLine("You are a student");
            } else if (isStudent && !isSmart) {
                Console.WriteLine("You are not a smart student");
            } else {
                Console.WriteLine("You are not a student and not smart");
            }

            // >, <, >=, <=, !=, ==
            if (1 < 3) {
                Console.WriteLine("number comparison was true");
            }

            int age = 16;

            bool canDrive = age >= 18 ? true : false;

            // switch
            char myGrade = 'A';
            switch (myGrade) {
                case 'a':
                case 'A':
                    Console.WriteLine("You Pass");
                    break;
                case 'f':
                case 'F':
                    Console.WriteLine("You fail");
                    break;
                default:
                    Console.WriteLine("Invalid grade");
                    break;
            }
        }

        static void Loops() {
            int index = 1;
            while (index <= 5) {
                Console.WriteLine(index);
                index++;
            }

            do {
                Console.WriteLine(index);
                index--;
            } while (index > 0);


            for (int i = 0; i < 5; i++) {
                Console.Write(i + " ");
            }

            int[] luckyNums = { 4, 8, 15, 16, 23, 42 };
            foreach (int luckyNum in luckyNums) {
                Console.WriteLine(luckyNum);
            }

            int j = 1;
            while (j <= 100) {
                if (j % 2 == 0) {
                    j++;
                    continue;
                }

                if (j == 9) { break; }

                Console.WriteLine(j);
                j++;
            }

        }

        static void RandomValue() {
            Random rand = new Random();
            Console.WriteLine(rand.NextDouble());
            Console.WriteLine(rand.Next(10));
            Console.WriteLine(rand.Next(1, 10));
        }

        static void Dates() {
            DateTime date = new DateTime(1974, 12, 21);
            Console.WriteLine("Day of Week : {0}", date.DayOfWeek);

            // You can change values
            date = date.AddDays(4);
            date = date.AddMonths(1);
            date = date.AddYears(1);
            Console.WriteLine("New Date : {0}", date.Date);

            // TimeSpan, used to define a time
            TimeSpan lunchTime = new TimeSpan(12, 30, 0);

            // Change values
            lunchTime = lunchTime.Subtract(new TimeSpan(0, 15, 0));
            lunchTime = lunchTime.Add(new TimeSpan(1, 0, 0));
            Console.WriteLine("New Time : {0}", lunchTime.ToString());
        }

        static void enums() {
            CarColor carColor = CarColor.Blue;
            Console.WriteLine("CarColor : {0}", carColor);
            Console.WriteLine("CarColor : {0}", (int)carColor);

            // Get all values in enum
            foreach (int i in Enum.GetValues(typeof(CarColor))) {
                Console.WriteLine(i);
            }

            // Get all names in enum
            foreach (string str in Enum.GetNames(typeof(CarColor))) {
                Console.WriteLine(str);
            }
        }

        private static int AddNumbers(int a, int b) {
            return a + b;
        }

        private static void DoubleIt(int x, out int solution) {
            solution = x * 2;
        }

        private static void swap(int a, int b) {
            int temp = a;
            a = b;
            b = temp;
        }
        private static void swap(ref int a, ref int b) {
            int temp = a;
            a = b;
            b = temp;
        }

        private static double SumMany(params double[] nums) {
            double sum = 0;
            foreach (double i in nums) {
                sum += i;
            }
            return sum;
        }

        static void Methods() {

            int a = 10, b = 10;

            int sum = AddNumbers(a, b);
            Console.WriteLine(sum);

            int solution;

            DoubleIt(15, out solution);

            int num1 = 10;
            int num2 = 20;

            Console.WriteLine($"Before swap: {num1} {num2}");

            swap(num1, num2);

            Console.WriteLine($"After swap: {num1} {num2}");

            swap(ref num1, ref num2);

            Console.WriteLine($"After swap with ref: {num1} {num2}");

            Console.WriteLine(SumMany(1.1, 2, 3));
        }

        public static void Main(string[] args) {
            //Printing();
            //Variables();
            //CastingConversion();
            FormartOutput();
            Strings();
            //StringBuider()
            //Numbers();
            //UserInput();
            //Arrays();
            //Conditionals();
            //Loops();
            //RandomValue();
            //Dates();
            //enums();
            //Methods();~

            
        }
    }
}
