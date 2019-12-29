/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AuBoPuTiAu;
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
public class AuBoPuTiAuDao {

    public List<AuBoPuTiAu> getAllBy(String str, String bookTitle) {
        String sql = "select books.title_id,title,pub_name,au_name,notes\n"
                + "from Books,Publishers,Authors,TitleAuthor\n"
                + "where books.pub_id=Publishers.pub_id\n"
                + "and Authors.au_id=TitleAuthor.au_id\n"
                + "and Books. title_id=TitleAuthor.title_id\n"
                + "and " + str + " like ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            List<AuBoPuTiAu> listResult = new ArrayList<>();
            ps.setString(1, "%" + bookTitle + "%");
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                listResult.add(new AuBoPuTiAu(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return listResult;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<AuBoPuTiAu> getAll() {
        String sql = "select Books.title_id, Books.title, pub_name, au_name, notes\n" +
                    "from Books, Publishers, TitleAuthor, Authors \n" +
                    "where Books.pub_id = Publishers.pub_id\n" +
                    "and Books.title_id = TitleAuthor.title_id\n" +
                    "and TitleAuthor.au_id = Authors.au_id\n" +
                    "order by Books.title_id asc";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            List<AuBoPuTiAu> listResult = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listResult.add(new AuBoPuTiAu(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return listResult;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        List<AuBoPuTiAu>lists=new AuBoPuTiAuDao().getAllBy("notes","a");
        System.out.println(lists);
    }
}
