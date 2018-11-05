package bg.rso;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userChoice;
        Scanner input = new Scanner(System.in);
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
}

