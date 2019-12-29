//package model;
//
//import entity.Staff;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Scanner;
//import ultis.ValidateStaff;
//
//public class StaffModel implements IComoMethod<Staff> {
//
//    @Override
//    public String inputName() {
//        Scanner scan = new Scanner(System.in);
//        String s;
//        boolean check;
//        do {
//            System.out.print("Enter name staff :");
//            s = scan.nextLine();
//            check = new ValidateStaff().getName(s);
//            if (!check) {
//                System.out.println("Enter again");
//            }
//        } while (!check);
//        String name = new StaffModel().process(s);
//        return name;
//    }
//
//    @Override
//    public String inputRollNumber() {
//        Scanner scan = new Scanner(System.in);
//        boolean test;
//        String rollNumber;
//        do {
//            System.out.print("Enter rollNumber:");
//            rollNumber = scan.nextLine();
//            test = new ValidateStaff().getRollNumber(rollNumber);
//            if (!test) {
//                System.out.println("You must enter rollNumber again");
//            }
//        } while (!test);
//        return rollNumber;
//    }
//
//    @Override
//    public boolean isGender() {
//        boolean gender = new ValidateStaff().isGender();
//        return gender;
//    }
//
//    private Long inputSalary() {
//        Scanner scan = new Scanner(System.in);
//        String s1;
//        boolean check2;
//        do {
//            System.out.print("Enter salary :");
//            s1 = scan.nextLine();
//            check2 = new ValidateStaff().getSalary(s1);
//            if (!check2) {
//                System.out.println("You must enter salary again");
//            }
//        } while (!check2);
//        long salary = Long.valueOf(s1);
//        return salary;
//    }
//
//    public Staff input() {
//        String name = inputName();
//        String rollNumber = inputRollNumber();
//        boolean gender = isGender();
//        long salary = inputSalary();
//        return new Staff(rollNumber, salary, name, gender);
//    }
//
//    private String process(String name) {
//        String result = "";
//
//        String[] s = (name.trim().replaceAll("\\s+", " ").toLowerCase()).trim().toLowerCase().split(" ");
//        for (String item : s) {
//            String s1 = item.charAt(0) + "";
//            result += item.replaceFirst(s1, s1.toUpperCase()) + " ";
//        }
//        return result;
//    }
//
//    @Override
//    public boolean add(ArrayList<Staff> list, Staff obj) {
//        return list.add(obj);
//    }
//
//    @Override
//    public void delete(ArrayList<Staff> list, String rollNumber) {
//        int test = -1;
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if ((list.get(i).getRollNumber()).equalsIgnoreCase(rollNumber)) {
//                list.remove(i);
//                test = 1;
//                break;
//            } else if (i == 0) {
//                test = -1;
//                break;
//            }
//        }
//        if (test == -1) {
//            System.out.println("Not found");
//        } else {
//            System.out.println("Delete sucessful");
//        }
//    }
//
//    @Override
//    public void update(ArrayList<Staff> list) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter rollNumber you want to update :");
//        String rollnumber = scan.nextLine();
//        int test = -1;
//        outer:
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (i == new StaffModel().getIndex(list, rollnumber)) {
//                test = 1;
//                while (true) {
//                    System.out.println("1.Update Name");
//                    System.out.println("2.Update Gender");
//                    System.out.println("3.Update Long");
//                    System.out.println("4.Exit");
//                    System.out.println("--------------");
//                    System.out.print("Funtion :");
//                    int funtion = Integer.valueOf(scan.nextLine());
//                    switch (funtion) {
//                        case 1: {
//                            list.get(i).setName(inputName());
//                            break;
//                        }
//                        case 2: {
//                            list.get(i).setGender(isGender());
//                            break;
//                        }
//                        case 3: {
//                            list.get(i).setSalary(inputSalary());
//                            break;
//                        }
//                        case 4: {
//                            break outer;
//                        }
//                        default: {
//                            System.out.println("Enter funtion again");
//                            break;
//                        }
//                    }
//                }
//            } else if (i == 0) {
//                test = -1;
//                break;
//            }
//        }
//        if (test == -1) {
//            System.out.println("Not found");
//        } else {
//            System.out.println("Update sucessful");
//        }
//    }
//
//    @Override
//    public int getIndex(ArrayList<Staff> list, String rollnumber) {
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if ((list.get(i).getRollNumber()).equalsIgnoreCase(rollnumber)) {
//                index = i;
//                break;
//            } else if (i == list.size() - 1) {
//                index = -1;
//                break;
//            }
//        }
//        return index;
//    }
//
//    @Override
//    public void display(ArrayList<Staff> list) {
//        list.forEach(s -> {
//            System.out.println(s.display());
//        });
//    }
//
//    @Override
//    public ArrayList<Staff> search(ArrayList<Staff> list, String str) {
//        boolean test = false;
//        ArrayList<Staff> newStaff = new ArrayList<>();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (str.contains(list.get(i).getName())) {
//                newStaff.add(list.get(i));
//                test = true;
//            }
//        }
//        if (test == false) {
//            System.out.println("Not found");
//        } else {
//            display(newStaff);
//        }
//        return newStaff;
//    }
//
//    @Override
//    public ArrayList<Staff> search(ArrayList<Staff> list, double str) {
//        boolean test = false;
//        ArrayList<Staff> newStaff = new ArrayList<>();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (str==list.get(i).getSalary()) {
//                newStaff.add(list.get(i));
//                test = true;
//            } else {
//            }
//        }
//        if (test == false) {
//            System.out.println("Not found");
//        } else {
//            display(newStaff);
//        }
//        return newStaff;
//    }
//
//    @Override
//    public void sort(ArrayList<Staff> list) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("1.Sort by name");
//        System.out.println("2.Sort by salary");
//        int choose;
//        do {
//            System.out.print("Enter funtion :");
//            choose = Integer.valueOf(scan.nextLine());
//            switch (choose) {
//                case 1: {
//                    list.sort(Comparator.comparing(Staff::getName).thenComparingDouble(Staff::getSalary));
//                    break;
//                }
//                case 2: {
//                    list.sort(Comparator.comparingDouble(Staff::getSalary).thenComparing(Staff::getName));
//                    break;
//                }
//                default: {
//                    System.out.println("Enter again");
//                }
//            }
//        } while (choose > 2);
//    }
//
//}
