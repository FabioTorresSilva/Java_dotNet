internal class Student
{
    int StudentId;
    int StudentId_POR_OMISSAO = 0;
    String FirstName;
    String FirstName_POR_OMISSAO = "sem nome";
    int Age;
    int Age_POR_OMISSAO = 0;
    String LastName;
    String LastName_POR_OMISSAO = "sem nome";
    double Grade;
    double Grade_POR_OMISSAO = 0;
    Boolean IsActive;
    Boolean IsActive_POR_OMISSAO = true;
    String Course;
    String Course_POR_OMISSAO = "sem curso";
    int StudentCount = 0;

    public Student()
    {
        this.StudentId = StudentId_POR_OMISSAO;
        this.FirstName = FirstName_POR_OMISSAO;
        this.Age = Age_POR_OMISSAO;
        this.LastName = LastName_POR_OMISSAO;
        this.Grade = Grade_POR_OMISSAO;
        this.IsActive = IsActive_POR_OMISSAO;
        this.Course = Course_POR_OMISSAO;
        StudentCount++;
    }
    public Student(int StudentId, String FirstName, String LastName, int Age, double Grade)
    {
        this.StudentId = StudentId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.Grade = Grade;
        this.IsActive = IsActive_POR_OMISSAO;
        this.Course = Course_POR_OMISSAO;
        StudentCount++;
    }

    public string GetFullName()
    {
        return $"{FirstName} {LastName}";
    }

    public int GetStudentCount()
    {
        return StudentCount;
    }

    public override string ToString()
    {
        return $"Aluno {FirstName} {LastName} de {Age} com nota {Grade} do curso {Course}";
    }

}