/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Books;
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
public class BooksDao {

    ResultSet rs;
    PreparedStatement ps;

    public List<Books> getAll() {

        String sql = "SELECT * FROM books";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Books> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Books(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5))
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Books getOne(String id) {
        String sql = "SELECT * FROM Books WHERE title_id =?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Books(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Books books) {
        int check = 0;
        String sql = "INSERT INTO Books(title_id, title, pub_id, notes)"
                + " VALUES(?, ?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, books.getTitle_id());
            ps.setObject(2, books.getTitle());
            ps.setObject(3, books.getPub_id());
            ps.setObject(4, books.getNotes());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Books books, String title_id, String username) {
        int check = 0;
        String sql = "  UPDATE Books SET title=?,pub_id=?,notes=?,username=?"
                + "  WHERE title_id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, books.getTitle());
            ps.setObject(2, books.getPub_id());
            ps.setObject(3, books.getNotes());
            ps.setObject(4, username);
            ps.setObject(5, title_id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String title_id) {
        int check = 0;
        String sql = "DELETE FROM Books WHERE title_id =?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, title_id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean insertBooks(String id, String title, String pub, String note, String username) throws Exception {
        if (getOne(id) != null) {
            return false;
        }
        String query = "SELECT * FROM Books";
        Connection con = SQLServerConnection.getConnection();
        ps = con.prepareStatement(query,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        rs = ps.executeQuery();
        rs.moveToInsertRow();
        rs.updateString("title_id", id);
        rs.updateString("title", title);
        rs.updateString("pub_id", pub);
        rs.updateString("notes", note);
        rs.updateString("username", username);
        rs.insertRow();
        rs.moveToCurrentRow();
        return true;
    }

    public static void main(String[] args) {
        Books books = new Books("Ty Quay", "0877", "nothing", "sa");
        boolean test = new BooksDao().update(books, "MC1546", "sa");
        System.out.println(test);
    }
}
