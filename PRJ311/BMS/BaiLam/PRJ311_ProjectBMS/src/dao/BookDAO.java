package dao;

import context.DBContext;
import controller.BookController;
import entity.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author langt
 */
public class BookDAO {

    static List<Books> list;
    ResultSet rs;
    PreparedStatement ps;

    //SELECT
    public List<Books> selectBooks() throws SQLException {
        String query = "select *\n"
                + "from Books";
        ps = BookController.conn.prepareStatement(query);
        rs = ps.executeQuery();
        list = new Vector<>();
        while (rs.next()) {
            String titleID = rs.getString("title_id");
            String title = rs.getString("title");
            String publishID = rs.getString("pub_id");
            String notes = rs.getString("notes");
            String userName = rs.getString("username");
            list.add(new Books(titleID, title, publishID, notes, userName));
        }
        rs.close();
        return list;
    }

    public Books selectBookByID(String titleID) {
        String query = "select *\n"
                + "from Books where title_id = '" + titleID + "'";
        try {
            ps = BookController.conn.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("title_id");
            String title = rs.getString("title");
            String publishID = rs.getString("pub_id");
            String notes = rs.getString("notes");
            String userName = rs.getString("username");
            return new Books(titleID, title, publishID, notes, userName);
        } catch (SQLException ex) {
            return null;
        }
    }

    //INSERT
    public boolean insertBooks(String id, String title, String pub, String note, String username) throws Exception {
        if (selectBookByID(id) != null) {
            return false;
        }
        String query = "select * from Books";
        ps = BookController.conn.prepareStatement(query,
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

    //DELETE
}
