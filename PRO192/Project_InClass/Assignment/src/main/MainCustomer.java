package main;

import IOData.SerializeFile;
import data.CustomerData;
import entity.Customer;
import java.util.ArrayList;
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
public class MainCustomer {

    public static ArrayList<Customer> listCustomer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int keepTrying = 1;
        SerializeFile serializeFile = new SerializeFile();
        CustomerData customerData = new CustomerData();
        process:
        do {
            // menu Customer
            System.out.println("\n\t\t1. Data");
            System.out.println("\t\t2. Add new Customers");
            System.out.println("\t\t3. Update Customers");
            System.out.println("\t\t4. Delete Customers");
            System.out.println("\t\t5. Search ");
            System.out.println("\t\t6. Sort  ");
            System.out.println("\t\t7. Display Customers");
            System.out.println("\t\t8. Save new list");
            System.out.println("\t\t9. Exit");
            System.out.println("\t\t-----------------------------------");
            System.out.print("\nYou choose: ");
            int choose = Integer.valueOf(scanner.nextLine());
            System.out.println("-------------------------------");
            switch (choose) {
                case 1: {
                    // tim file
                    System.out.println("\n1. Add new list");
                    System.out.println("2. Load file");
                    System.out.print("You choose: ");
                    int f1 = Integer.valueOf(scanner.nextLine());
                    if (f1 == 1) {
                        System.out.println("Add new list sucess!!!");
                        System.out.println("-------------------------------");
                    } else {
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine().trim();
                        listCustomer = (ArrayList<Customer>) serializeFile.readDataFromFile(fileName);
                        System.out.println("Load data success!!!");
                        System.out.println("-------------------------------");
                    }
                    break;
                }
                case 2: {
                    // addCustomer
                    System.out.print("\tEnter number customer want to add:");
                    int number = scanner.nextInt();
                    for (int i = 0; i < number; i++) {
                        System.out.println("\n\t\tInformation of new customer  " + (i + 1) + "\n");
                        boolean flag = customerData.add(listCustomer, customerData.inputCustomer());
                        if (flag) {
                            System.out.println("Add new customer sucess!!");
                        } else {
                            System.out.println("Add new customer fail!!");
                        }
                        if (i == (number - 1)) {
                            scanner.nextLine();
                        }
                        System.out.println("---------------------------------");
                    }
                    break;
                }
                case 3: {
                    //Update
                    System.out.print("Enter customerID you want to update :");
                    int customerID = Integer.valueOf(scanner.nextLine());
                    boolean test = customerData.update(listCustomer, customerID);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("\n\tUpdate sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 4: {
                    //delete
                    System.out.print("Enter customerID you want to delete :");
                    int customerID = Integer.valueOf(scanner.nextLine());
                    boolean test = customerData.delete(listCustomer, customerID);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Delete sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 5: {
                    //Search
                    ArrayList<Customer> newCustomer = new ArrayList<>();
                    newCustomer = customerData.search(listCustomer);
                    if (newCustomer.isEmpty() == true) {
                        System.out.println("Not found");
                    } else {
                        customerData.display(newCustomer);
                    }
                    break;
                }
                case 6: {
                    customerData.sort(listCustomer);
                    customerData.display(listCustomer);
                    break;
                }
                case 7: {
                    //Display
                    customerData.display(listCustomer);
                    System.out.println("---------------------------------");
                    break;
                }
                case 8: {
                    System.out.print("Enter file name:");
                    String fileName = scanner.nextLine();
                    boolean isCheck = serializeFile.writeDataToFile(listCustomer, fileName);
                    if (isCheck) {
                        System.out.println("Save data success!!!");
                    } else {
                        System.out.println("Save data fail!!!");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 9: {
                    break process;
                }
                default:
                    System.out.println("Enter function again");
                    break;
            }
            // Sub menu
            System.out.println("\n");
            System.out.println("1. Back to menu Customer");
            System.out.println("2. Exit");
            System.out.print("You choose: ");
            keepTrying = Integer.valueOf(scanner.nextLine());
            System.out.println("");
            System.out.println("- - - - - - - - - - - -");
        } while (keepTrying == 1);
    }
}
