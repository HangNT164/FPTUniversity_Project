/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Publishers;
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
public class PublishersDao {

    public List<Publishers> getAll() {
        String query = "SELECT * FROM Publishers";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            List<Publishers> lists = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lists.add(new Publishers(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Publishers account, String username) {
        int check = 0;
        String sql = "UPDATE Publishers SET pub_name=?,pub_address=? WHERE pub_id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getPub_name());
            ps.setObject(2, account.getPub_address());
            ps.setObject(3, username);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String userName) {
        int check = 0;
        String sql = "DELETE FROM Publishers WHERE pub_id= ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, userName);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Publishers getOne(String pub_id) {
        String sql = "SELECT * FROM publishers WHERE pub_id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, pub_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Publishers(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String selectByPublisher(String name) {
        String sql = "SELECT pub_id FROM publishers WHERE pub_name = '" + name + "'";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("pub_id");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
