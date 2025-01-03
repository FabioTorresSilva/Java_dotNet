package pt.upskill.iet.restupskill.dto;

import pt.upskill.iet.restupskill.models.Student;

import java.util.Objects;

public class StudentDTO {

    private String name;
    private int age;

    private long _id;

    public StudentDTO(long _id, String name, int age) {
        this.name = name;
        this.age = age;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", _id=" + _id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO student = (StudentDTO) o;
        return age == student.age && _id == student._id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, _id);
    }

    //Student para Student dto
    public static StudentDTO fromStudent(Student student) {
        if (student !=null){
            return new StudentDTO(student.getId(), student.getName(), student.getAge());
        }
        return null;
    }
}
