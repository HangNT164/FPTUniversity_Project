/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ImageAvata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class ImageAvataDao implements ICommonDao<ImageAvata> {

    private ImageAvata getValueImage(ResultSet rs) {
        try {
            return ImageAvata.builder()
                    .id(rs.getInt(1))
                    .accountDetailID(rs.getInt(2))
                    .imageLink(rs.getString(3))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueImage(ImageAvata image, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, image.getAccountDetailID());
                ps.setObject(2, image.getImageLink());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<ImageAvata> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageAvata getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ImageAvata image) {
        int check = 0;
        String query = "INSERT INTO image_avata(account_detail_id, image_link)"
                + "VALUES(?, ?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueImage(image, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, ImageAvata obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ImageAvata getOneByAccountDetail(int accountDetailID) {
        String query = "SELECT * FROM image_avata WHERE account_detail_id = ? AND deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    try {
                        return ImageAvata.builder()
                                .id(rs.getInt(1))
                                .accountDetailID(rs.getInt(2))
                                .imageLink(rs.getString(3))
                                .build();
                    } catch (SQLException e) {
                        e.printStackTrace(System.out);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean updateImageLink(int accountDetailID, String imageLink) {
        int check = 0;
        String query = "UPDATE image_avata SET image_link = ? WHERE account_detail_id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, imageLink);
                ps.setObject(2, accountDetailID);
            }
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
