package bg.rso.employees;

import bg.rso.departments.Department;

public class Developer extends Employee {

    public Developer(long employeeId, String employeeName, String designation, Department department) {
        super(employeeId, employeeName, designation, department);
    }

    @Override
    public int teamSize() {
        return 1;
    }
}
