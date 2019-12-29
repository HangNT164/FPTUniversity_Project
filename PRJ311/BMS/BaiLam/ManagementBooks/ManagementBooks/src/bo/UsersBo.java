/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.UsersDao;
import entity.Users;
import java.awt.Component;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HangNT
 */
public class UsersBo {

    private UsersDao usersDao = new UsersDao();

    public String signUp(String userName, String passWord, String confirmPassWord) {
        if (usersDao.isDulicapte(userName)) {
            return "Dulicapte Account";
        } else {
            if (passWord != null && passWord.equals(confirmPassWord)) {
                Users users = new Users(userName, "Users", passWord, "User of the sysment"); // 0:ban,1:active,2:pending
                if (usersDao.add(users)) {
                    return "Sign Up successful";
                } else {
                    return "Please enter again!!!";
                }
            } else {
                return "Confirm Password not match";
            }
        }
    }

    // login account
    public String signInAccount(String name, String password) {
        Users users = usersDao.login(name, password);
        String s = "";
        if (name.isEmpty() || password.isEmpty()) {
            s = "Please enter full information";
        } else {
           if(users!=null){
               s="Login successful";
           }else{
               s="Login Fail";
           }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = new UsersBo().signInAccount("sa", "123456");
        System.out.println(s);
    }

    public void displayTable(JTable table, List<Users> lists) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int stt = 0;
        for (Users s : lists) {

            Object[] rowData2 = new Object[]{
                "" + ++stt, "" + s.getUserName(), "" + s.getDisplayName(), "" + s.getDescription()
            };
            ((DefaultTableModel) table.getModel()).addRow(rowData2);
        }
    }

    public void clearInput(JTextField... jTextFields) {
        for (JTextField jTextField : jTextFields) {
            jTextField.setText("");
        }
    }

    public int getTypeLanguage(Component c, int number) {
        String url = "resource/languages";
        if (number == 1) {
            Locale locale = new Locale("vi", "VN");
            ResourceBundle rb = ResourceBundle.getBundle(url, locale);
            JFrame frame = new JFrame();
            frame.setTitle(rb.getString("Title"));

        }
        return number;
    }

    public void hideSomeThings(JComboBox jComboBox, JTextField jTextField, JLabel... jLabels) {
        jComboBox.setVisible(false);
        jTextField.setVisible(false);
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(false);
        }
    }

    public void showSomeThings(JComboBox jComboBox, JTextField jTextField, JLabel... jLabels) {
        jComboBox.setVisible(true);
        jTextField.setVisible(true);
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(true);
        }
    }

    public void showSomeThings(JLabel... jLabels) {
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(true);
        }
    }
}
