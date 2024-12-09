package pt.org.upskill.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final String vatNumber;
    private final List<Employee> employees;
    private final List<Task> tasks;
    private final List<Store> stores;
    private String name;
    private String website;
    private String phone;
    private String email;

    public Organization(String vatNumber) {
        this.vatNumber = vatNumber;
        employees = new ArrayList<>();
        tasks = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public boolean employs(Employee employee) {
        return employees.contains(employee);
    }


    public Task createTask(String reference, String description, String informalDescription,
                           String technicalDescription, int duration, double cost,
                           TaskCategory taskCategory, Employee employee) {

        Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                taskCategory, employee);

        if (addTask(task)) {
            return task;
        }
        return null;
    }

    public Store createStore(String openingTime, String closingTime, String designation, String address) {
        Store store = new Store(openingTime, closingTime, designation, address);
        if (addStore(store)) {
            return store;
        }
        return null;
    }

    public Employee createEmployee(String email,String name, int phone, String position) {
        Employee employee = new Employee(email,name, phone, position);
        if (addEmployee(employee)) {
            return employee;
        }
        return null;
    }

    private boolean addTask(Task task) {
        boolean success = false;
        if (validate(task)) {
            success = tasks.add(task.clone());
        }
        return success;
    }

    private boolean addStore(Store store) {
        boolean success = false;
        if (validateStore(store)) {
            success = stores.add(store.clone());
        }
        return success;
    }

    private boolean validate(Task task) {
        return tasksDoNotContain(task);
    }

    private boolean validateStore(Store store) {
        return storesDoNotContain(store);
    }

    private boolean tasksDoNotContain(Task task) {
        return !tasks.contains(task);
    }

    private boolean storesDoNotContain(Store store) {
        return !stores.contains(store);
    }

    public boolean anyEmployeeHasEmail(String email) {
        boolean result = false;
        for (Employee employee : employees) {
            if (employee.hasEmail(email)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization that = (Organization) o;
        return vatNumber.equals(that.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }

    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    public Organization clone() {
        Organization clone = new Organization(this.vatNumber);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);

        for (Employee in : this.employees) {
            clone.employees.add(in.clone());
        }

        for (Task in : this.tasks) {
            clone.tasks.add(in.clone());
        }

        for (Store in : this.stores) {
            clone.stores.add(in.clone());
        }
        return clone;
    }
}