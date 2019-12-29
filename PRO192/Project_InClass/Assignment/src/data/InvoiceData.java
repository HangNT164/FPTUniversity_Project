/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Customer;
import entity.Invoice;
import entity.InvoiceLine;
import entity.Products;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HangNT
 */
public class InvoiceData {
    ArrayList<Invoice> invoices;
    int ID;
    public int getIndex(ArrayList<Invoice> listInvoice, int id) {
        for (int i = 0; i < listInvoice.size(); i++) {
            if (listInvoice.get(i).getInvoiceNumber() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Invoice> search(ArrayList<Invoice> listInvoice) {
        ArrayList<Invoice> listSearch = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter ID want to search :");
        int id = Integer.valueOf(scan.nextLine().trim());
        for (int i = listInvoice.size() - 1; i >= 0; i--) {
            if (id == listInvoice.get(i).getInvoiceNumber()) {
                listSearch.add(listInvoice.get(i));
            }
        }
        return listSearch;
    }

    public void buy(ArrayList<Customer> listCustomer, ArrayList<Products> listProducts) {
        String input = null;//continue to buy/ stop buying
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("your Customer ID:");
        int customerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Your date:");
        String date = scanner.nextLine().trim();
        CustomerData customerData = new CustomerData();
        Customer customer = customerData.get(listCustomer, customerID);
        System.out.println("Customer Name: " + customer.getCustomerName());
        Invoice invoice = new Invoice(date, customer);
        do {
            System.out.print("Product ID:");
            int productID = Integer.parseInt(scanner.nextLine());
            Products product = new ProductData().get(listProducts, productID);
            System.out.println("You have selected " + product.getProductName());
            System.out.print("Quantity:");
            float quantity = Float.parseFloat(scanner.nextLine());
            InvoiceLine line = new InvoiceLine(invoice, product, quantity,
                    product.getPrice());
            invoice.getLines().add(line);
            System.out.println("Do you want to continue! (Y/N)");

            input = scanner.nextLine().trim();
        } while (!input.equalsIgnoreCase("N"));
        invoices.add(invoice);
        System.out.println("Your InvoiceID:" + invoice.getInvoiceNumber());
    }

    public Invoice get(int ID) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceNumber() == ID) {
                return invoice;
            }
        }
        return null;
    }

    public void printAInvoice() {
        System.out.print("Invoice ID:");
        Scanner scanner = new Scanner(System.in);
        int InvoiceID = Integer.parseInt(scanner.nextLine());
        Invoice invoice = invoices.get(InvoiceID);
        System.out.println(invoice.toString());
    }
}
