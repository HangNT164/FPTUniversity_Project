/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.BookController;
import static dao.BookDAO.list;
import entity.DefaultDisplay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import ui.Login;

/**
 *
 * @author langt
 */
public class DefaultDisplayDAO {
    List<DefaultDisplay> list;
    
    public List<DefaultDisplay> selectDefault() throws SQLException{
        String sql = "select Books.title_id, Books.title, pub_name, au_name, notes\n" +
                    "from Books, Publishers, TitleAuthor, Authors \n" +
                    "where Books.pub_id = Publishers.pub_id\n" +
                    "and Books.title_id = TitleAuthor.title_id\n" +
                    "and TitleAuthor.au_id = Authors.au_id\n" +
                    "order by Books.title_id asc";
        BookController.conn = new Login().getConnect();
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new Vector<>();
        while(rs.next()){
            String titleID = rs.getString("title_id");
            String title = rs.getString("title");
            String publisher = rs.getString("pub_name");
            String author = rs.getString("au_name");
            String notes = rs.getString("notes");
            list.add(new DefaultDisplay(titleID, title, publisher, author, notes));
        }
        rs.close();
        return list;
    }
    
}
