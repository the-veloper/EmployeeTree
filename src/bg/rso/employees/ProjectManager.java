package bg.rso.employees;

import bg.rso.departments.Department;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManager extends Employee {
    List<Employee> managingEmployees = new ArrayList<Employee>();

    public ProjectManager(String employeeName, String designation, Department department) {
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
        String managingdepartments = managingEmployees.stream()
                .filter( employee -> employee instanceof TeamLead)
                .map(employee -> (TeamLead) employee)
                .map(teamLead -> teamLead.department.getDepartmentName())
                .collect(Collectors.joining(", "));
        if(managingdepartments.isEmpty()) {
            managingdepartments = "no ";
        }
       String details =  sb.append(employeeName).append(" manages ").append(managingdepartments).append(" departments").toString();
       return details;
    }
}
