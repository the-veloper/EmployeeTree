package bg.rso;

import bg.rso.departments.Department;
import bg.rso.employees.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final int EMPLOYEE_MANAGER = 1;
    public static final int EMPLOYEE_PM = 2;
    public static final int EMPLOYEE_TEAMLEAD = 3;
    public static final int EMPLOYEE_DEV = 4;
    private static HashMap<String, Department> departments;
    private static HashMap<String, Employee> employees;

    public static void loadData() {
        employees = DataLoader.loadEmployees();
        departments = DataLoader.loadDepartments();
        System.out.println("loaded");
    }

    public static void saveData() {
        DataLoader.saveDepartments(departments);
        DataLoader.saveEmployees(employees);
    }

    public static void main(String[] args) {
        loadData();
        int userChoice;
        do {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    break;
                case 2:

                    break;
            }
            clear();
        } while (userChoice != 3);
        saveData();
    }

    public static void clear() {
        System.out.print("\u001b[2J");
        System.out.flush();
    }

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add employee");
        System.out.println("2 - List Employees");
        System.out.println("3 - Quit");

        selection = input.nextInt();
        return selection;
    }
    public static Employee createEmployee(int type, String name, String designation, String department) {
        Department d = departments.get(department);
        switch (type) {
            case EMPLOYEE_DEV:
                return new Developer(name,designation,d);
            case EMPLOYEE_MANAGER:
                return new Manager(name,designation,d);
            case EMPLOYEE_PM:
                return new ProjectManager(name,designation,d);
             case EMPLOYEE_TEAMLEAD:
                return new TeamLead(name,designation,d);
        }
        return null;
    }
    public static Department createDepartment(String departmentName) {
        if(departments == null) {
            System.out.println("aloo");
        }
       if (departments.containsKey(departmentName)) {
           System.out.println("eho");
        return departments.get(departmentName);
       }
       return new Department(departmentName);
    }
}

