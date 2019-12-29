package dao;

import entity.TitleAuthor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class TitleAuthorDao {

    static Map<String, TitleAuthor> map;

    public List<TitleAuthor> getAll() {

        String sql = "SELECT * FROM TitleAuthor";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<TitleAuthor> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new TitleAuthor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3))
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(TitleAuthor account) {
        int check = 0;
        String sql = "INSERT INTO TitleAuthor(au_id, title_id, au_ord)"
                + " VALUES(?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getAu_id());
            ps.setObject(2, account.getTitle_id());
            ps.setObject(3, account.getAu_ord());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(TitleAuthor account, String title_id) {
        int check = 0;
        String sql = "UPDATE TitleAuthor SET au_ord=? WHERE title_id=?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getAu_ord());
            ps.setObject(2, title_id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String title_id) {
        int check = 0;
        String sql = "Delete from TitleAuthor where  title_id=?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, title_id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public TitleAuthor getOne(String title_id) {

        String sql = "SELECT * FROM TitleAuthor WHERE title_id=?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, title_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TitleAuthor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertTitleAuthor(String auID, String titleID, int au_ord) throws SQLException {
        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = SQLServerConnection.getConnection();
        try {
            String sqlFix = "select * from titleauthor";
            ps = con.prepareStatement(sqlFix,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = ps.executeQuery();
            rs.moveToInsertRow();
            rs.updateString("au_id", auID);
            rs.updateString("title_id", titleID);
            rs.updateInt("au_ord", (au_ord));
            rs.insertRow();
            rs.moveToCurrentRow();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Map<String, TitleAuthor> selectTitleAuthor() throws Exception {
        String sql = "select * from titleauthor";
        Connection con = SQLServerConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
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
}
