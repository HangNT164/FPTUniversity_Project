/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HangNT
 */
public class Validate {

    private static final String REGEX_NAME = "[a-z A-Z]+";
    private static final String REGEX_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    private static final String REGEX_ROLLNUMBER = "(H|S)([A|B|E]{1})(\\d{6})";
    private static final String REGEX_PHONE = "0[9|8|3|7|5][0-9]{8}";
    private static final String REGEX_EMAIL = "^[\\w-\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    public static String getPhoneNumber(JTextField jTextField) {
        String phoneNumber = jTextField.getText();
        if (phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
            return null;
        } else {
            if (phoneNumber.matches(REGEX_PHONE)) {
                return phoneNumber;
            }
        }
        return null;
    }

    public static String getEmail(JTextField jTextField) {
        String email = jTextField.getText();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
            return null;
        } else {
            if (email.matches(REGEX_EMAIL)) {
                return email;
            }
        }
        return null;
    }

    public static String getName(JTextField jTextField) {
        String name = jTextField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
            return null;
        } else {
            if (name.matches(REGEX_NAME)) {
                return name;
            }
        }
        return null;

    }

    public static String getRollNumber(JTextField jTextField) {
        String rollNumber = jTextField.getText();
        if (rollNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
        } else {
            if (rollNumber.matches(REGEX_ROLLNUMBER)) {
                return rollNumber;
            }
        }
        return null;

    }

    public static String getPassword(JPasswordField jTextField) {
        String password = jTextField.getText();
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
        } else {
            if (password.matches(REGEX_PASSWORD)) {
                return password;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter password at least "
                        + "length is 8 and contains at least"
                        + "number and lower case and upper case");
            }
        }
        return null;
    }
}
