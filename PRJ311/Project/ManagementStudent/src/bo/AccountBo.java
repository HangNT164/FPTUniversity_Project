/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.AccountDAO;
import entity.Account;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HangNT
 */
public class AccountBo {

    AccountDAO accountDAO = new AccountDAO();

    public String signUp(String userName, String passWord, String confirmPassWord) {
        if (accountDAO.isDulicapte(userName)) {
            return "Dulicapte Account";
        } else {
            if (passWord!=null&&passWord.equals(confirmPassWord)) {
                Account account = new Account(userName, passWord, 2, 1); // 0:ban,1:active,2:pending
                if (accountDAO.add(account)) {
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
        List<Account> listAccounts = accountDAO.getAll();
        String s = "";
        if (name.isEmpty() || password.isEmpty()) {
            s = "Please enter full information";
        } else {
            for (Account a : listAccounts) {
                if (name.equalsIgnoreCase(a.getUserName())) {
                    if (!password.equals(a.getPassword())) {
                        s = "Password wrong";
                    } else {
                        s = "Login successful";
                    }
                } else {
                    s = "Account not exist";
                }
            }
        }
        return s;
    }

    public void displayTableAccount(JTable table, List<Account> lists) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        Object[] rowData = new Object[4];
        int stt = 0;
        for (Account s : lists) {
            rowData[0] = "  " + ++stt;
            rowData[1] = "  " + s.getUserName();
            rowData[2] = s.getType() == 1 ? "  Ban" : "  Active";
            rowData[3] = s.getStatus() == 1 ? "  Admin" : "  Staff";
            dtm.addRow(rowData);

        }
    }
}
