package dao;

import controller.BookController;
import entity.Author;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author langt
 */
public class AuthorDAO {
    static List<Author> list;

    //SELECT ALL PUBLISHER
    public List<Author> selectAu() throws SQLException {
        String sql = "select * from authors";
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new Vector<>();
        while (rs.next()) {
            String publishID = rs.getString("au_id");
            String publishName = rs.getString("au_name");
            String pubAddress = rs.getString("au_address");
            list.add(new Author(publishID, publishName, pubAddress));
        }
        rs.close();
        return list;
    }
    public String getAuthorID(String name) throws SQLException {
        String sql = "select au_id from authors where au_name = '" + name+"'";
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String result = "";
        if(rs.next()) result = rs.getString("au_id");
        System.out.println(result);
        return result;
    }
   
}
