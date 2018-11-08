package bg.rso.employees;

import bg.rso.departments.Department;

import java.util.ArrayList;
import java.util.List;

public class TeamLead extends Employee {
    List<Employee> managingEmployees = new ArrayList<Employee>();

    public TeamLead(String employeeName, String designation, Department department) {
        super(employeeName, designation, department);
    }

    public boolean manages(Employee employee) {
        return managingEmployees.add(employee);
    }

    public boolean stopManaging(Employee employee) {
        return managingEmployees.remove(employee);
    }

    @Override
    public int teamSize() {
        return managingEmployees.stream().mapToInt(employee -> employee.teamSize()).sum();
    }

    @Override
    public String fullDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(employeeName)
                .append(" manages the ")
                .append(department.getDepartmentName())
                .append(" department ")
                .append("He has ")
                .append(manager.employeeName)
                .append(" as manager");
        return sb.toString();
    }
}
