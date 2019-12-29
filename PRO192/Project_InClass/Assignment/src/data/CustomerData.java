/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Customer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import ultis.Validate;

/**
 *
 * @author HangNT
 */
public class CustomerData extends BaseDao<Customer> {

    @Override
    public boolean add(ArrayList<Customer> list, Customer c) {
        return list.add(c);
    }

    @Override
    public boolean delete(ArrayList<Customer> list, int id) {
        boolean test = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == getIndex(list, id)) {
                list.remove(i);
                test = true;
                break;
            } else if (i == 0) {
                test = false;
                break;
            }
        }
        return test;
    }

    @Override
    public boolean update(ArrayList<Customer> list, int id) {
        Scanner scan = new Scanner(System.in);
        int index = getIndex(list, id);
        if (index == -1) {
            return false;
        } else {
            OUTER:
            while (true) {
                System.out.println("1.Update Name");
                System.out.println("2.Update Gender");
                System.out.println("3.Exit");
                System.out.println("--------------");
                System.out.print("Your function :");
                int funtion = Integer.valueOf(scan.nextLine().trim());
                switch (funtion) {
                    case 1: {
                        list.get(index).setCustomerName(new CustomerData().inputName());
                        break;
                    }
                    case 2: {
                        list.get(index).setGender(isGender());
                        break;
                    }
                    case 3: {
                        break OUTER;
                    }
                    default: {
                        System.out.println("Enter funtion again!!!");
                        break;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public int getIndex(ArrayList<Customer> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomerID() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(ArrayList<Customer> list) {
        list.forEach(s -> System.out.println(s));
    }

    @Override
    public ArrayList<Customer> search(ArrayList<Customer> list) {
        ArrayList<Customer> listSearch = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Search name");
        System.out.println("2.Search ID");
        int choose;
        do {
            System.out.print("Enter function:");
            choose = Integer.valueOf(scan.nextLine());
            switch (choose) {
                case 1: {
                    System.out.print("Enter name want to search:");
                    String name = scan.nextLine().trim();
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).getCustomerName().equalsIgnoreCase(name)) {
                            listSearch.add(list.get(i));
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter ID want to search :");
                    int ID = Integer.valueOf(scan.nextLine().trim());
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (ID == list.get(i).getCustomerID()) {
                            listSearch.add(list.get(i));
                        }
                    }
                    break;
                }

                default: {
                    System.out.println("Out of ranger!!!");
                    System.out.println("Enter again!!!");
                    break;
                }
            }
        } while (choose > 2);
        return listSearch;
    }

    @Override
    public void sort(ArrayList<Customer> list) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sort by name");
        System.out.println("2.Sort by ID");
        int choose;
        do {
            System.out.print("Enter funtion :");
            choose = Integer.valueOf(scan.nextLine().trim());
            switch (choose) {
                case 1: {
                    list.sort(Comparator.comparing(Customer::getCustomerName).thenComparingInt(Customer::getCustomerID));
                    break;
                }
                case 2: {
                    list.sort(Comparator.comparingInt(Customer::getCustomerID).thenComparing(Customer::getCustomerID));
                    break;
                }
                default: {
                    System.out.println("Not function. Enter again");
                }
            }
        } while (choose > 2);
    }

    @Override
    public String inputName() {
        Scanner scan = new Scanner(System.in);
        String s;
        boolean check;
        do {
            System.out.print("Enter Customer name :");
            s = scan.nextLine().trim();
            check = new Validate().getName(s);
            if (!check) {
                System.out.println("Enter again!!!");
            }
        } while (!check);
        String name = new CustomerData().process(s);
        return name;
    }

    private int inputID() {
        Scanner scanner = new Scanner(System.in);
        String s;
        boolean check;
        do {
            System.out.print("Enter customer ID:");
            s = scanner.nextLine().trim();
            check = new Validate().getID(s);
            if (!check) {
                System.out.println("Enter again!!!");
            }
        } while (!check);
        int id = Integer.valueOf(s);
        return id;
    }

    private boolean isGender() {
        boolean gender = new Validate().isGender();
        return gender;
    }

    private String process(String name) {
        String result = "";

        String[] s = (name.trim().replaceAll("\\s+", " ").toLowerCase()).trim().toLowerCase().split(" ");
        for (String item : s) {
            String s1 = item.charAt(0) + "";
            result += item.replaceFirst(s1, s1.toUpperCase()) + " ";
        }
        return result;
    }

    public Customer inputCustomer() {
        String customerName = new CustomerData().inputName();
        boolean gender = new CustomerData().isGender();
        int id = new CustomerData().inputID();
        Customer c = new Customer(customerName, id, gender);
        return c;
    }

    public Customer get(ArrayList<Customer> listCustomer, int ID) {
        for (Customer customer : listCustomer) {
            if (customer.getCustomerID() == ID) {
                return customer;
            }
        }
        return null;
    }
}
