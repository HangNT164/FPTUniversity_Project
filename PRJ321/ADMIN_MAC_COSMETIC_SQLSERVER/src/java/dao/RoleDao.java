/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class RoleDao implements ICommonDao<Role> {

    private Role getValueRole(ResultSet rs) {
        try {
            return Role.builder()
                    .id(rs.getInt(1))
                    .roleName(rs.getString(2))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueRole(Role subCate, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, subCate.getRoleName());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Role> getAll() {
        String query = "SELECT * FROM role WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Role> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueRole(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Role getOne(int id) {
        String query = "SELECT * FROM role WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueRole(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Role subCate) {
        int check = 0;
        String query = "INSERT INTO role(role_name)"
                + "VALUES(?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueRole(subCate, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Role subCate) {
        int check = 0;
        String query = "UPDATE role SET role_name = ?"
                + "WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            setValueRole(subCate, ps);
            if (ps != null) {
                ps.setObject(2, id);
            }
            check = setValueRole(subCate, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE role SET deleted =1 WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Role getOneByAccountID(String accountID) {
        String query = "SELECT role.*\n"
                + "FROM role,account\n"
                + "WHERE role.id=account.role_id\n"
                + "AND account.email= ?\n"
                + "AND role.deleted =0\n"
                + "AND account.deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, accountID);
                ResultSet rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    return getValueRole(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new RoleDao().getOneByAccountID("thuyhangnknd@gmail.com"));
    }
}
