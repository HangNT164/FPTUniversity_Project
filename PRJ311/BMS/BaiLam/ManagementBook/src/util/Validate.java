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

    private final String regexName = "[a-z A-Z]+";
    private final String regexPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    private final String regexBookId = "[a-zA-Z]{2}\\d{4}";

    public String getName(JTextField jTextField) {
        String name = jTextField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
        } else {
            if (name.matches(regexName)) {
                return name;
            }
        }
        return null;

    }

    public String getBookID(JTextField jTextField) {
        String name = jTextField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
        } else {
            if (name.matches(regexBookId)) {
                return name;
            }
        }
        return null;

    }

    public String getPassword(JPasswordField jTextField) {
        String password = jTextField.getText();
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information!!!");
        } else {
            if (password.matches(regexPassword)) {
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
