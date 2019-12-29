package dao;

import entity.Users;
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
public class UsersDao {

    public List<Users> getAll() {

        String sql = "SELECT * FROM Users";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            List<Users> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Users(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4))
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Users getOne(String userName) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                         rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Users account) {
        int check = 0;
        String sql = "INSERT INTO Users(username, displayname, password, description)"
                + " VALUES(?, ?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getUserName());
            ps.setObject(2, account.getDisplayName());
            ps.setObject(3, account.getPassword());
            ps.setObject(4, account.getDescription());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Users account, String username) {
        int check = 0;
        String sql = "UPDATE Users SET displayname=?,password=?,description=?" + "WHERE usename like ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, account.getDisplayName());
            ps.setObject(2, account.getPassword());
            ps.setObject(3, account.getDescription());
            ps.setObject(4, "%" + username + "%");
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String userName) {
        int check = 0;
        String sql = "DELETE FROM Users WHERE usename like ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, "%" + userName + "%");
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    // ham check login
    public Users login(String name, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out); //gom 2 viec la : no se print ra loi , va bao ra dong loi
        }
        return null;
    }

    public boolean isDulicapte(String name) {
        String sql = "SELECT * FROM users WHERE username = ? ";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name );
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace(System.out); //gom 2 viec la : no se print ra loi , va bao ra dong loi
        }
        return false;
    }

}
