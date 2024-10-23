namespace FP02;

public class Student
{
    public static int StudentCount { get; private set; } = 0;

    public int StudentId { get; }
    public string FirstName { get; set; } = "Default";
    public string LastName { get; set; }
    public int Age { get; set; }
    public double Grade { get; set; }
    public bool IsActive { get; set; }
    public string Course { get; private set; }

    public Student()
    {
        StudentCount++;
        StudentId = StudentCount + 1;
    }

    public Student(string firstName, string lastName, int age, double grade) : this()
    {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Grade = grade;
    }

    public string GetFullName()
    {
        return $"{FirstName} {LastName}";
    }

    public void SetCourse(string course)
    {
        Course = course;
    }

}