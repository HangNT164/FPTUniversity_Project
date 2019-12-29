package main;

import IOData.SerializeFile;
import data.InvoiceData;
import entity.Invoice;
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
public class MainInvoice {

    public static ArrayList<Invoice> listInvoice = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int keepTrying = 1;
        SerializeFile serializeFile = new SerializeFile();
        InvoiceData invoiceData = new InvoiceData();
        process:
        do {
            // menu Invoice
            System.out.println("\n\t\t1. Data");
            System.out.println("\t\t2. Add new Invoice");
            System.out.println("\t\t3.Show invoice");
            System.out.println("\t\t3. Save new list");
            System.out.println("\t\t4. Exit");
            System.out.println("-----------------------------------");
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
                    } else {
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine().trim();
                        listInvoice = (ArrayList<Invoice>) serializeFile.readDataFromFile(fileName);
                        System.out.println("Load data success!!!");
                        System.out.println("-------------------------------");
                    }
                    break;
                }
                case 2: {
                    // buyInvoice
                    invoiceData.buy( MainCustomer.listCustomer, MainProducts.listProduct);
                    System.out.println("---------------------------------");
                    break;
                }
                case 3:{
                    //showInvoice
                    invoiceData.printAInvoice();
                }
                case 4: {
                    System.out.print("Enter file name:");
                    String fileName = scanner.nextLine();
                    boolean isCheck = serializeFile.writeDataToFile(listInvoice, fileName);
                    if (isCheck) {
                        System.out.println("Save data success!!!");
                    } else {
                        System.out.println("Save data fail!!!");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 5: {
                    break process;
                }
                default:
                    System.out.println("Enter function again");
                    break;
            }
            // Sub menu
            System.out.println("\n");
            System.out.println("1. Back to menu Invoice");
            System.out.println("2. Exit");
            System.out.print("You choose: ");
            keepTrying = Integer.valueOf(scanner.nextLine());
            System.out.println("");
            System.out.println("- - - - - - - - - - - -");
        } while (keepTrying == 1);
    }
}
