/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HangNT
 */
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    private int invoiceNumber;
    private String invoiceDate;
    private Customer customer;
    private ArrayList<InvoiceLine> listInvoice = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(int invoiceNumber, String invoiceDate, Customer customer) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
    }

    public Invoice(String invoiceDate, Customer customer) {
        this.invoiceDate = invoiceDate;
        this.customer = customer;
    }


    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<InvoiceLine> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoice(ArrayList<InvoiceLine> listInvoice) {
        this.listInvoice = listInvoice;
    }

    public double getTotal() {
        double sum = 0;
        for (InvoiceLine il : listInvoice) {
            sum += il.getTotal();
        }
        return sum;
    }

    public ArrayList<InvoiceLine> getLines() {
        return listInvoice;
    }

    @Override
    public String toString() {
        System.out.println("\t\t-------------------------------------------------------------------------------");
        listInvoice.forEach((il) -> {
            System.out.println("\t\t" + il.getProduct().getProductName()
                    + "|\t\t" + il.getQuantity()
                    + "|\t\t" + il.getPrice()
                    + "|\t\t" + il.getTotal());
        });
        System.out.println("\t\t-------------------------------------------------------------------------------");
        return null;
    }

}
