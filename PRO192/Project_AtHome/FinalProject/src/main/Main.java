/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Shado
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int isContinue = 0;
        // start loop
        process:
        do {
            // main menu
            System.out.println("\t\t\t- - Menu Management - -");
            System.out.println("\t\t\t- 1. Staff            -");
            System.out.println("\t\t\t- 2. Student          -");
            System.out.println("\t\t\t- 3. Exit             -");
            System.out.println("\t\t\t- - - - - - - - - - - -");
            int choose;
            do {
                System.out.print("\nYou choose: ");
                choose = Integer.valueOf(scan.nextLine());
                System.out.println("- - - - - - - - - - - -");
                switch (choose) {
                    case 1:
                        StaffMain.main(args);
                        break;
                    case 2:
                        StudentMain.main(args);
                        break;
                    case 3:
                        break process;
                    default:
                        System.out.println("Enter choose angain");
                        break;
                }
                System.out.println("- - - - - - - - - - - -");
            } while (choose > 3);
            // Sub menu
            do {
                System.out.println("1. Back to main Menu");
                System.out.println("2. Exit");
                System.out.print("You choose: ");
                isContinue = Integer.valueOf(scan.nextLine());
                System.out.println("");
                switch (isContinue) {
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
            } while (isContinue > 2);
        } while (isContinue == 1);
    }
}
