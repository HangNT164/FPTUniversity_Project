package main;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HangNT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int function = 0;
        int keepTrying = 1;
        Outer:
        while (keepTrying == 1) {
            do {
                new Main().menu();
                System.out.print("Enter function :");
                function = Integer.parseInt(scanner.nextLine());
                System.out.println("-------------------------------");

                switch (function) {
                    case 1: {
                        MainCustomer.main(args);
                        break;
                    }
                    case 2: {
                        MainProducts.main(args);
                        break;
                    }
                    case 3: {
                        MainInvoice.main(args);
                        break;
                    }
                    case 4: {
                        break Outer;
                    }
                    default: {
                        System.out.println("Out of ranger!!!");
                        System.out.println("------------------------------------");
                    }
                }
            } while (function != 4);
            // subMenu
            do {
                System.out.println("1. Back to main Menu");
                System.out.println("2. Exit");
                System.out.print("You choose: ");
                keepTrying = Integer.valueOf(scanner.nextLine());
                System.out.println("");
                switch (keepTrying) {
                    case 1: {
                        continue;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        System.out.println("Enter again");
                    }
                    System.out.println("- - - - - - - - - - - -");
                }
            } while (keepTrying > 2);
        }

    }

    private void menu() {
        System.out.println("\t\t\t- - Menu Management - -");
        System.out.println("\t\t\t- 1. Customers            -");
        System.out.println("\t\t\t- 2. Products          -");
        System.out.println("\t\t\t- 3. Invoices             -");
        System.out.println("\t\t\t- 4. Exit             -");
        System.out.println("\t\t\t- - - - - - - - - - - -");
    }
}
