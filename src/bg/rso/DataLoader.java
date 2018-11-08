package bg.rso;

import bg.rso.departments.Department;
import bg.rso.employees.Employee;

import java.io.*;
import java.util.HashMap;

public class DataLoader {
    private static String departmentsFile = "departments.ser";
    private static String employeesFile = "employees.ser";

    public static void saveEmployees(HashMap employees) {
        try
        {
            FileOutputStream fos =
                    new FileOutputStream(employeesFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("Could not save!");
        }
    }
    public static void saveDepartments(HashMap departments) {
        try
        {
            FileOutputStream fos =
                    new FileOutputStream(departmentsFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(departments);
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            //ioe.printStackTrace();
            System.out.println("Could not save!");
        }
    }
    public static HashMap<String, Department> loadDepartments() {
        HashMap<String, Department> map;
        try
        {
            FileInputStream fis = new FileInputStream(departmentsFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap<String, Department>) ois.readObject();
            ois.close();
            fis.close();
            return map;
        }catch(IOException | ClassNotFoundException ioe)
        {
            //ioe.printStackTrace();
            return new HashMap<String, Department>();
        }
    }
    public static HashMap<String, Employee> loadEmployees() {
        HashMap<String, Employee> map;
        try
        {
            FileInputStream fis = new FileInputStream(employeesFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap<String, Employee>) ois.readObject();
            ois.close();
            fis.close();
            return map;
        }catch(IOException | ClassNotFoundException ioe)
        {
            //ioe.printStackTrace();
            return new HashMap<String, Employee>();
        }
    }
}
