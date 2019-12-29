/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.BookController;
import entity.TitleAuthor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author langt
 */
public class TitleAuthorDAO {

    static Map<String, TitleAuthor> map;

    //select title author\
    public Map<String, TitleAuthor> selectTitleAuthor() throws Exception {
        String sql = "select * from titleauthor";
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        map = Collections.synchronizedMap(new HashMap());
        while (rs.next()) {
            String auID = rs.getString("au_id");
            String titleID = rs.getString("title_id");
            int auOrd = rs.getInt("au_ord");
            map.put(auID + titleID, new TitleAuthor(auID, titleID, auOrd));
        }
        return map;
    }

    public boolean insertTitleAuthor(String auID, String titleID) throws SQLException {
        if (map.containsKey(auID + titleID)) {
            return false;
        }
        PreparedStatement ps;
        int au_ord = 0;
        ResultSet rs = null;
        String sql = "select * from titleauthor where title_id = " + titleID;
        try {
            ps = BookController.conn.prepareStatement(sql,
                    ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (auID.equals(rs.getString("au_id"))) {
                    return false;
                }
                au_ord++;
            }
        } catch (SQLException ex) {
            String sqlFix = "select * from titleauthor";
            ps = BookController.conn.prepareStatement(sqlFix,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
        }
        if (rs != null) {
            rs.moveToInsertRow();
            rs.updateString("au_id", auID);
            rs.updateString("title_id", titleID);
            rs.updateInt("au_ord", (au_ord + 1));
            rs.insertRow();
            rs.moveToCurrentRow();
        }
        return true;
    }

}
