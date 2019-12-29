/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.AccountAndDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class AccountAndDetailDao {

    public List<AccountAndDetail> getAllUser() {
        String query = "  SELECT account.id,account_detail.id,name,email,mobile,gender,address,create_date\n"
                + "  FROM account,account_detail\n"
                + "  WHERE account.account_detail_id=account_detail.id AND role_id = 1 AND account.deleted=0 AND account_detail.deleted=0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<AccountAndDetail> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(AccountAndDetail.builder()
                            .accountID(rs.getInt(1))
                            .accountDetailID(rs.getInt(2))
                            .name(rs.getString(3))
                            .email(rs.getString(4))
                            .phone(rs.getString(5))
                            .gender(rs.getInt(6))
                            .address(rs.getString(7))
                            .createDate(rs.getString(8))
                            .build());
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<AccountAndDetail> getAllAdmin() {
        String query = "  SELECT account.id,account_detail.id,name,email,mobile,gender,address,create_date\n"
                + "  FROM account,account_detail\n"
                + "  WHERE account.account_detail_id=account_detail.id AND role_id = 2 AND account.deleted=0 AND account_detail.deleted=0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<AccountAndDetail> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(AccountAndDetail.builder()
                            .accountID(rs.getInt(1))
                            .accountDetailID(rs.getInt(2))
                            .name(rs.getString(3))
                            .email(rs.getString(4))
                            .phone(rs.getString(5))
                            .gender(rs.getInt(6))
                            .address(rs.getString(7))
                            .createDate(rs.getString(8))
                            .build());
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new AccountAndDetailDao().getAllAdmin());
    }
}
