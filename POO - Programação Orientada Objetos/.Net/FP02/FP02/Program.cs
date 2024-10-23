namespace FP02
{
    class Program
    {
        private static void Um()
        {
            int numStudents = 2; // Change this to specify the number of students to input.
            Student[] students = new Student[numStudents];

            Student s = new Student();
            Console.WriteLine(s.FirstName);

            for (int i = 0; i < numStudents; i++)
            {
                Console.WriteLine($"Enter Student {i + 1} Details:");
                Console.Write("First Name: ");
                string firstName = Console.ReadLine() ?? string.Empty;
                Console.Write("Last Name: ");
                string lastName = Console.ReadLine() ?? string.Empty;
                Console.Write("Age: ");
                int age = int.Parse(Console.ReadLine() ?? string.Empty);
                Console.Write("Grade: ");
                double grade = double.Parse(Console.ReadLine() ?? string.Empty);

                students[i] = new Student(firstName, lastName, age, grade);
                students[i].SetCourse("Math"); // You can change the course here.

                Console.WriteLine();
            }

            Console.WriteLine("Student Information:");
            foreach (var student in students)
            {
                Console.WriteLine($"Student ID: {student.StudentId}");
                Console.WriteLine($"Full Name: {student.GetFullName()}");
                Console.WriteLine($"Age: {student.Age}");
                Console.WriteLine($"Grade: {student.Grade}");
                Console.WriteLine($"Course: {student.Course}");
                Console.WriteLine();
            }

            Console.WriteLine($"Total Students: {Student.StudentCount}");
        }

        private static int GetValidMonth()
        {
            int month;
            bool isValidMonth = false;

            do
            {
                Console.Write("Enter a month: ");
                month = int.Parse(Console.ReadLine() ?? string.Empty);

                if (month > 0 && month < 13)
                {
                    isValidMonth = true;
                }
                else
                {
                    Console.WriteLine("Invalid month. Please enter a valid month.");
                }
            } while (!isValidMonth);

            return month;
        }

        private static void Dois()
        {
            Console.Write("Enter car make: ");
            string make = Console.ReadLine() ?? string.Empty;

            Console.Write("Enter car model: ");
            string model = Console.ReadLine() ?? string.Empty;

            Console.Write("Enter car year: ");
            int year = int.Parse(Console.ReadLine() ?? string.Empty);

            Car car = new Car(make, model, year);

            double gallons = 0;
            int month = 0;

            do
            {
                Console.Write($"Enter fuel (gallons) (0 to exit): ");
                gallons = double.Parse(Console.ReadLine() ?? string.Empty);

                if (gallons > 0)
                {
                    month = GetValidMonth();
                    car.AddFuelInput(gallons, month);
                }

            } while (gallons > 0);

            car.DisplayMonthlyReports();
        }

        private static void Tres()
        {
            Point pointA = new Point(1, 1);
            Point pointB = new Point(4, 1);
            Point pointC = new Point(4, 4);
            Point pointD = new Point(1, 4);

            Circle circle = new Circle(pointA, 3);
            Rectangle rectangle1 = new Rectangle(pointA, 3, 3);
            Rectangle rectangle2 = new Rectangle(pointB, 2, 2);
            Triangle triangle = new Triangle(pointA, pointB, pointC);

            double circleArea = circle.CalculateArea();
            double circleCircumference = circle.CalculatePerimeter();
            double rectangleArea1 = rectangle1.CalculateArea();
            double rectanglePerimeter1 = rectangle1.CalculatePerimeter();
            double rectangleArea2 = rectangle2.CalculateArea();
            double rectanglePerimeter2 = rectangle2.CalculatePerimeter();
            double triangleArea = triangle.CalculateArea();
            double trianglePerimeter = triangle.CalculatePerimeter();

            bool overlapRectangles = rectangle1.OverlapsWith(rectangle2);

            Console.WriteLine($"Circle Area: {circleArea}");
            Console.WriteLine($"Circle Circumference: {circleCircumference}");
            Console.WriteLine($"Rectangle 1 Area: {rectangleArea1}");
            Console.WriteLine($"Rectangle 1 Perimeter: {rectanglePerimeter1}");
            Console.WriteLine($"Rectangle 2 Area: {rectangleArea2}");
            Console.WriteLine($"Rectangle 2 Perimeter: {rectanglePerimeter2}");
            Console.WriteLine($"Triangle Area: {triangleArea}");
            Console.WriteLine($"Triangle Perimeter: {trianglePerimeter}");

            if (overlapRectangles)
            {
                Console.WriteLine("Rectangle 1 and Rectangle 2 overlap.");
            }
            else
            {
                Console.WriteLine("Rectangle 1 and Rectangle 2 do not overlap.");
            }
        }

        static void Main(string[] args)
        {
            //Um();
            //Dois();
            Tres();
        }

    }
}

