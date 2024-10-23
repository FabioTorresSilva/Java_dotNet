Student[] students = new Student[2];

for (int i = 0; i < 2; i++)
{
    Console.WriteLine($"Enter details for student {i + 1}:");

    Console.Write("Enter Student ID: ");
    int studentId = int.Parse(Console.ReadLine());

    Console.Write("Enter First Name: ");
    string firstName = Console.ReadLine();

    Console.Write("Enter Last Name: ");
    string lastName = Console.ReadLine();

    Console.Write("Enter Age: ");
    int age = int.Parse(Console.ReadLine());

    Console.Write("Enter Grade: ");
    double grade = double.Parse(Console.ReadLine());


    students[i] = new Student(studentId, firstName, lastName, age, grade);
    Console.WriteLine(students[i]);
}



