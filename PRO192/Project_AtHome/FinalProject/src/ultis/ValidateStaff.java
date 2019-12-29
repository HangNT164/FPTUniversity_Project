package ultis;

import java.util.Scanner;

public class ValidateStaff {

    public boolean getRollNumber(String rollNumber) {
        //code
        String digit = "S(\\d{4})";
        return rollNumber.matches(digit);
    }
    public boolean getName(String name) {
        String kiTu;
        kiTu = "[a-z A-Z]{2,50}";
        return name.matches(kiTu);
    }
    public boolean isGender() {
        boolean check;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Enter gender:");
            String gender = scan.nextLine();
            if (gender.equalsIgnoreCase("male")) {
                check = true;
                break;
            } else if (gender.equalsIgnoreCase("female")) {
                check = false;
                break;
            } else {
                System.out.println("You must enter again");
            }
        }
        return check;
    }
    public boolean getSalary(String salary) {
        //code
        String digit = "\\d{5,10000}";
        return salary.matches(digit);
    }
}
