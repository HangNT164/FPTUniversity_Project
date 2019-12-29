/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AccountDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class AccountDetailDao implements ICommonDao<AccountDetail>, AccountDetailCommonDao {

    private AccountDetail getValueAccountDetail(ResultSet rs) {
        try {
            return AccountDetail.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .mobile(rs.getString(3))
                    .gender(rs.getInt(4))
                    .address(rs.getString(5))
                    .createDate(rs.getString(6))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueAccountDetail(AccountDetail user, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, user.getName());
                ps.setObject(2, user.getMobile());
                ps.setObject(3, user.getGender());
                ps.setObject(4, user.getAddress());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<AccountDetail> getAll() {
        String query = "SELECT * FROM account_detail WHERE deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<AccountDetail> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueAccountDetail(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public AccountDetail getOne(int id) {
        String query = "SELECT * FROM account_detail where id=? AND deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueAccountDetail(rs);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(AccountDetail user) {
        int check = 0;
        String query = "INSERT INTO account_detail(name,mobile,gender,address)"
                + "VALUES(?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueAccountDetail(user, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public int addAccountDetailReturnId(AccountDetail user) {
        String query = "INSERT INTO account_detail(name,mobile,gender,address)"
                + "VALUES(?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {
            if (ps != null) {
                ps.setObject(1, user.getName());
                ps.setObject(2, user.getMobile());
                ps.setObject(3, user.getGender());
                ps.setObject(4, user.getAddress());
                int isCheck = ps.executeUpdate();
                if (isCheck > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    rs.next();
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    @Override
    public boolean update(int id, AccountDetail user) {
        int check = 0;
        String query = "UPDATE account_detail SET name = ?,"
                + "mobile =? ,gender=?,address=?,create_date=? WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                // Chuẩn bị câu query
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueAccountDetail(user, ps);
            if (ps != null) {
                ps.setObject(5, user.getCreateDate());
                ps.setObject(6, id);
            }
            check = setValueAccountDetail(user, ps) ? ps.executeUpdate() : 0;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE account_detail SET deleted = 1 WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
        int check = 0;
        String query = "DELETE FROM account_detail WHERE id = ?;";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
