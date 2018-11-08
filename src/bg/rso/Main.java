package bg.rso;

import bg.rso.departments.Department;
import bg.rso.employees.*;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final int EMPLOYEE_MANAGER = 1;
    public static final int EMPLOYEE_PM = 2;
    public static final int EMPLOYEE_TEAMLEAD = 3;
    public static final int EMPLOYEE_DEV = 4;
    private static Map<String, Department> departments = new Map<String, Department>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Department get(Object key) {
            return null;
        }

        @Override
        public Department put(String key, Department value) {
            return null;
        }

        @Override
        public Department remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends Department> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<Department> values() {
            return null;
        }

        @Override
        public Set<Entry<String, Department>> entrySet() {
            return null;
        }
    };


    public static void main(String[] args) {
        int userChoice;
        do {
            userChoice = menu();
            clear();
        } while (userChoice != 3);
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
}

