/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Authors;
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
public class AuthorsDao {

    public List<Authors> getAll() {
        String query = "SELECT * FROM Authors";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            List<Authors> lists = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lists.add(new Authors(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Authors getOne(String au_id) {
        String sql = "SELECT * FROM Authors WHERE au_id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, au_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Authors(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Authors account) {
        int check = 0;
        String sql = "INSERT INTO Authors(au_id, au_name, au_address)"
                + " VALUES(?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getAu_id());
            ps.setObject(2, account.getAu_name());
            ps.setObject(3, account.getAddress());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Authors account, String au_id) {
        int check = 0;
        String sql = "UPDATE Authors SET au_name=?,au_address=?" + "WHERE au_id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getAu_name());
            ps.setObject(2, account.getAddress());
            ps.setObject(3, au_id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String au_id) {
        int check = 0;
        String sql = "DELETE FROM authors WHERE au_id = ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, au_id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String getAuthorID(String name) {
        String sql = "SELECT au_id FROM authors WHERE au_name = '" + name + "'";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            String result = "";
            if (rs.next()) {
                result = rs.getString("au_id");
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
