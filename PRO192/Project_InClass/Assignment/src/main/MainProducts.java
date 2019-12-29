package main;

import IOData.SerializeFile;
import data.ProductData;
import entity.Products;
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
public class MainProducts {

    public static ArrayList<Products> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int keepTrying = 1;
        SerializeFile serializeFile = new SerializeFile();
        ProductData productData = new ProductData();
        process:
        do {
            // menu Products
            System.out.println("\n\t\t1. Data");
            System.out.println("\t\t2. Add new Products");
            System.out.println("\t\t3. Update Products");
            System.out.println("\t\t4. Delete Products");
            System.out.println("\t\t5. Search ");
            System.out.println("\t\t6. Sort  ");
            System.out.println("\t\t7. Display Products");
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
                        listProduct = (ArrayList<Products>) serializeFile.readDataFromFile(fileName);
                        System.out.println("Load data success!!!");
                        System.out.println("-------------------------------");
                    }
                    break;
                }
                case 2: {
                    // addProducts
                    System.out.print("\tEnter number Products want to add:");
                    int number = scanner.nextInt();
                    for (int i = 0; i < number; i++) {
                        System.out.println("\n\t\tInformation of new customer  " + (i + 1) + "\n");
                        boolean flag = productData.add(listProduct, productData.inputProduct());
                        if (flag) {
                            System.out.println("Add new Products sucess!!");
                        } else {
                            System.out.println("Add new Products fail!!");
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
                    System.out.print("Enter ProductID you want to update :");
                    int productID = Integer.valueOf(scanner.nextLine());
                    boolean test = productData.update(listProduct, productID);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("\n\tUpdate sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 4:
                    //delete
                    System.out.print("Enter ProductID you want to delete :");
                    int productID = Integer.valueOf(scanner.nextLine());
                    boolean test = productData.delete(listProduct, productID);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Delete sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;

                case 5: {
                    //Search
                    ArrayList<Products> newProduct = new ArrayList<>();
                    newProduct = productData.search(listProduct);
                    if (newProduct.isEmpty() == true) {
                        System.out.println("Not found");
                    } else {
                        productData.display(newProduct);
                    }
                    break;
                }
                case 6: {
                    productData.sort(listProduct);
                    productData.display(listProduct);
                    break;
                }
                case 7: {
                    //Display
                    productData.display(listProduct);
                    System.out.println("---------------------------------");
                    break;
                }
                case 8: {
                    System.out.print("Enter file name:");
                    String fileName = scanner.nextLine().trim();
                    boolean isCheck = serializeFile.writeDataToFile(listProduct, fileName);
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
            System.out.println("1. Back to menu Products");
            System.out.println("2. Exit");
            System.out.print("You choose: ");
            keepTrying = Integer.valueOf(scanner.nextLine());
            System.out.println("");
            System.out.println("- - - - - - - - - - - -");
        } while (keepTrying == 1);
    }
}
