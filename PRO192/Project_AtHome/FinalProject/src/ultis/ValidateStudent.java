package ultis;

import java.util.Scanner;

public class ValidateStudent {

    public boolean getRollNumber(String rollNumber) {
        //code
        String kiTu;
        kiTu = "(H|S)([A|B|E]{1})(\\d{6})";
        return rollNumber.matches(kiTu);
    }

    public boolean getName(String name) {
        String kiTu;
        kiTu = "[a-z A-Z]{2,}";
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

    public boolean getMark(String mark) {
        //code
        String digit;
        digit = "10|\\d{1}(.)\\d";
        return mark.matches(digit);
    }
}
