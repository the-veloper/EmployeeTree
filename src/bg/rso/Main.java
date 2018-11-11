package bg.rso;

import bg.rso.departments.Department;
import bg.rso.employees.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiConsumer;

public class Main {
    public static final int EMPLOYEE_MANAGER = 1;
    public static final int EMPLOYEE_PM = 2;
    public static final int EMPLOYEE_TEAMLEAD = 3;
    public static final int EMPLOYEE_DEV = 4;
    private static HashMap<String, Department> departments;
    private static HashMap<String, Employee> employees;
    private static Scanner scanner = new Scanner( System.in );

    /*
     * Calls the DataLoader class loading methods.
     */
    public static void loadData() {
        employees = DataLoader.loadEmployees();
        departments = DataLoader.loadDepartments();
        System.out.println("loaded");
    }

    /*
     * Calls the Dataloader class saving methods.
     */
    public static void saveData() {
        DataLoader.saveDepartments(departments);
        DataLoader.saveEmployees(employees);
    }

    /*
     * Prints the main menu and handles main menu userchoices.
     */
    public static void main(String[] args) {
        loadData();
        int userChoice;
        do {
            userChoice = menu();
            switch (userChoice) {
                case 1:
                    employeeStep();
                    break;
                case 2:
                    listEmployees();
                    break;
            }
            clear();
        } while (userChoice != 3);
        saveData();
    }

    /*
     * When chosen "Add employee" gets the employee info and creates an employee.
     */
    public static void employeeStep() {
        String name = "";
        String department = "";
        String designation = "";
        int type = 0;
        String manager = "";
        Department d;
        Employee e;
        System.out.println("Employee data:");
        System.out.println("-------------------------\n");
        while(type == 0) {
            System.out.println("1 - Manager");
            System.out.println("2 - PM");
            System.out.println("3 - TeamLead");
            System.out.println("4 - Developer");
            System.out.print("Employee Type: ");
            type = scanner.nextInt();
        }
        while(name.isEmpty()) {
            System.out.print("Name: ");
            name = scanner.nextLine();
        }
        while(department.isEmpty()) {
            System.out.print("Department: ");
            department = scanner.nextLine();
        }
        d = createDepartment(department);
        departments.put(department, d);
        while(designation.isEmpty()) {
            System.out.print("Designation: ");
            designation = scanner.nextLine();
        }
        e = createEmployee(type, name, designation, department);
        while((manager.isEmpty() || !employees.containsKey(manager)) && employees.size() != 0) {
            System.out.print("Manager: ");
            manager = scanner.nextLine();
        }
        employees.put(name, e);
        if(employees.containsKey(manager)) {
            Employee mng = employees.get(manager);
            mng.manages(e);
            e.setManager(mng);
        }
        saveData();
    }

    /*
     * Clears the screen.
     */
    public static void clear() {
//        System.out.print("\u001b[2J");
        //        System.out.flush();
    }

    /*
     * Loops through employees and prints them in format "<id> - <name>"
     */
    public static void listEmployees() {
        Set<String> employeenames = employees.keySet();
        int i = 1;
        for (String s: employeenames) {
            System.out.println(i + " - " + s);
            i++;
        }
        System.out.println("ID: ");
        int selected = scanner.nextInt();
        System.out.println(employees.get(employeenames.toArray()[selected-1]).fullDetails());
    }

    /*
     * Main menu text
     */
    public static int menu() {

        int selection;

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add employee");
        System.out.println("2 - List Employees");
        System.out.println("3 - Quit");

        selection = scanner.nextInt();
        return selection;
    }
    /*
     * returns a new employee based on the parameters given.
     */
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
    /*
     * Returns a existing or new department.
     */
    public static Department createDepartment(String departmentName) {
       if (departments.containsKey(departmentName)) {
        return departments.get(departmentName);
       }
       return new Department(departmentName);
    }
}

