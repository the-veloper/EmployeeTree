package bg.rso.departments;

public class Department {
    protected String departmentName;

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public String shortDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("'").append(departmentName).append("'");
        return builder.toString();
    }
    public Department(String departmentName) {
        super();
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return shortDetails();
    }

}
