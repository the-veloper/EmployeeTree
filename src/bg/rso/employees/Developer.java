package bg.rso.employees;

import bg.rso.departments.Department;

public class Developer extends Employee {

    public Developer(String employeeName, String designation, Department department) {
        super(employeeName, designation, department);
    }

    @Override
    public int teamSize() {
        return 1;
    }

    @Override
    public boolean manages(Employee employee) {
        return false;
    }

    @Override
    public boolean stopManaging(Employee employee) {
        return false;
    }
}
