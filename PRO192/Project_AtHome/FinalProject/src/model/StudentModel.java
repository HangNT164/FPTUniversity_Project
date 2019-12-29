package model;

import entity.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import ultis.ValidateStudent;

public class StudentModel implements IComoMethod<Student> {

    @Override
    public String inputName() {
        Scanner scan = new Scanner(System.in);
        String s;
        boolean check;
        do {
            System.out.print("Enter name student :");
            s = scan.nextLine().trim();
            check = new ValidateStudent().getName(s);
            if (!check) {
                System.out.println("Enter again");
            }
        } while (!check);
        String name = new StudentModel().process(s);
        return name;
    }

    @Override
    public String inputRollNumber() {
        Scanner scan = new Scanner(System.in);
        boolean test;
        String rollNumber;
        do {
            System.out.print("Enter rollNumber:");
            rollNumber = scan.nextLine().trim();
            test = new ValidateStudent().getRollNumber(rollNumber);
            if (!test) {
                System.out.println("You must enter rollNumber again");
            }
        } while (!test);
        return rollNumber;
    }

    @Override
    public boolean isGender() {
        boolean gender = new ValidateStudent().isGender();
        return gender;
    }

    private double inputMark() {
        Scanner scan = new Scanner(System.in);
        String s1;
        boolean check2;
        do {
            System.out.print("Enter mark :");
            s1 = scan.nextLine().trim();
            check2 = new ValidateStudent().getMark(s1);
            if (!check2) {
                System.out.println("You must enter mark again");
            }
        } while (!check2);
        double mark = Double.valueOf(s1);
        return mark;
    }

    public Student input() {
        String name = inputName();
        String rollNumber = inputRollNumber();
        boolean gender = isGender();
        double mark = inputMark();
        return new Student(rollNumber, mark, name, gender);
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

    @Override
    public boolean add(ArrayList<Student> list, Student student) {
        return list.add(student);
    }

    @Override
    public boolean update(ArrayList<Student> list, String rollNumber) {
        Scanner scan = new Scanner(System.in);
        int index = getIndex(list, rollNumber);
        if (index == -1) {
            return false;
        } else {
            OUTER:
            while (true) {
                System.out.println("1.Update Name");
                System.out.println("2.Update Gender");
                System.out.println("3.Update Mark");
                System.out.println("4.Exit");
                System.out.println("--------------");
                System.out.print("Funtion :");
                int funtion = Integer.valueOf(scan.nextLine().trim());
                switch (funtion) {
                    case 1: {
                        list.get(index).setName(inputName());
                        break;
                    }
                    case 2: {
                        list.get(index).setGender(isGender());
                        break;
                    }
                    case 3: {
                        list.get(index).setMark(inputMark());
                        break;
                    }
                    case 4: {
                        break OUTER;
                    }
                    default: {
                        System.out.println("Enter funtion again");
                        break;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean delete(ArrayList<Student> list, String rollNumber) {
        boolean test = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == getIndex(list, rollNumber)) {
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
    public int getIndex(ArrayList<Student> list, String rollNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equalsIgnoreCase(rollNumber.trim())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(ArrayList<Student> list) {
        list.forEach(s -> System.out.println(s.display()));
    }

    @Override
    public ArrayList<Student> search(ArrayList<Student> list) {
        ArrayList<Student> newStudent = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Search name");
        System.out.println("2.Search mark");
        System.out.println("3.Search rollNumber");
        int choose;
        do {
            System.out.print("Enter function:");
            choose = Integer.valueOf(scan.nextLine().trim());
            switch (choose) {
                case 1: {
                    System.out.print("Enter name:");
                    String name = scan.nextLine().trim();
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
                            newStudent.add(list.get(i));
                        }
                    }
                    break;
                }
                case 2: {
                    newStudent.clear();
                    System.out.print("Enter mark:");
                    double mark = Double.valueOf(scan.nextLine().trim());
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (mark == list.get(i).getMark()) {
                            newStudent.add(list.get(i));
                        }
                    }
                    break;
                }
                case 3: {
                    newStudent.clear();
                    System.out.print("Enter rollNumber:");
                    String rollNumber = scan.nextLine().trim();
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).getRollNumber().toUpperCase().contains(rollNumber.toUpperCase())) {
                            newStudent.add(list.get(i));
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Not function.Enter again");
                    break;
                }
            }
        } while (choose > 3);
        return newStudent;
    }

    @Override
    public void sort(ArrayList<Student> list) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sort by name");
        System.out.println("2.Sort by mark");
        System.out.println("3.Sort by rollNumber");
        int choose;
        do {
            System.out.print("Enter funtion :");
            choose = Integer.valueOf(scan.nextLine().trim());
            switch (choose) {
                case 1: {
                    list.sort(Comparator.comparing(Student::getName).thenComparingDouble(Student::getMark));
                    break;
                }
                case 2: {
                    list.sort(Comparator.comparingDouble(Student::getMark).thenComparing(Student::getName));
                    break;
                }
                case 3: {
                    list.sort((Student o1, Student o2) -> o1.getRollNumber().compareTo(o2.getRollNumber()));
                    break;
                }
                default: {
                    System.out.println("Not function. Enter again");
                }
            }
        } while (choose > 3);
        //Collections.sort(list); // xuoi // dung java<7
        //nguoc 
        //Collections.sort(list, Collections.reverseOrder());
        // lamda

        //        list.sort((o1, o2) -> { // java 8 thi moi ap dung dc lamda.java 7 thi phai new va return 
        //            //return o1.getName().compareTo(o2.getName());
        //            if (o1.getMark() - o2.getMark() > 0) {
        //                return 1;
        //            } else if (o1.getMark() - o2.getMark() == 0) {
        //                return 0;
        //            } else {
        //                return -1;
        //            }
        //        });
//        list.sort(Comparator.comparing(Student::getMark));
//        list.sort((Student o1, Student o2) -> {
//            if (o1.getName().equals(o2.getName())) {
//                if (o1.getMark() - o2.getMark() > 0) {
//                    return 1;
//                } else if (o1.getMark() - o2.getMark() == 0) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            } else {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        list.sort(Comparator.comparing(Student::getName).thenComparingDouble(Student::getMark));
    }

}
