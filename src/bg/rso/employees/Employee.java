package bg.rso.employees;

import bg.rso.departments.Department;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected String employeeName;
    protected String designation;
    protected Department department;
    protected Employee manager;

    public Employee(String employeeName, String designation, Department department) {
        super();
        this.employeeName = employeeName;
        this.designation = designation;
        this.department = department;
    }
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee e) {
        this.manager = e;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public abstract int teamSize();
    public abstract boolean manages(Employee employee);
    public abstract boolean stopManaging(Employee employee);

    public String fullDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [")
                .append(", ").append(employeeName)
                .append(", ").append(designation)
                .append(", ").append(department)
                .append(", Team=").append(teamSize())
                .append("]");
        return builder.toString();
    }

    public String shortDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("'").append(employeeName).append("'");
        return builder.toString();
    }

    @Override
    public String toString() {
        return shortDetails();
    }
}
