/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import java.util.Scanner;

/**
 *
 * @author HangNT
 */
public class Validate {

    public boolean getID(String id) {
        String kiTu;
        kiTu = "\\d{6}";
        return id.matches(kiTu);
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

    public boolean getName(String name) {
        String kiTu;
        kiTu = "[a-z A-Z]{1,}";
        return name.matches(kiTu);
    }

    public boolean getPrice(String price) {
        String digit;
        digit = "\\d{1,}|\\d{1,}(.)\\d{1,}";
        return price.matches(digit);
    }

}
