package pt.org.upskill.domain;

import java.util.Objects;

public class Employee {
    private String email;
    private String name;
    private String position;
    private int phone;

    public Employee(String email, String name, int phone, String position) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.position = position;
    }

    public Employee(String email) {
        this.email = email;
        this.name = "";
        this.phone = 0;
        this.position = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email != null && email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean hasEmail(String email) {
        return this.email != null && this.email.equals(email);
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Employee clone() {
        return new Employee(this.email, this.name, this.phone, this.position);
    }
}
