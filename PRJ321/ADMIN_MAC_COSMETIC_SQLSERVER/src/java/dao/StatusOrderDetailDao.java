/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.StatusOrderDetail;
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
public class StatusOrderDetailDao implements ICommonDao<StatusOrderDetail> {

    private StatusOrderDetail getValueStatusOrderDetail(ResultSet rs) {
        try {
            return StatusOrderDetail.builder()
                    .id(rs.getInt(1))
                    .statusOrderName(rs.getString(2))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueStatusOrderDetail(StatusOrderDetail subCate, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, subCate.getStatusOrderName());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<StatusOrderDetail> getAll() {
        String query = "SELECT * FROM status_order_detail WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<StatusOrderDetail> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueStatusOrderDetail(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public StatusOrderDetail getOne(int id) {
        String query = "SELECT * FROM status_order_detail WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueStatusOrderDetail(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(StatusOrderDetail subCate) {
        int check = 0;
        String query = "INSERT INTO status_order_detail(status_order_detail_name)"
                + "VALUES(?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueStatusOrderDetail(subCate, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, StatusOrderDetail subCate) {
        int check = 0;
        String query = "UPDATE status_order_detail SET status_order_name = ?"
                + "WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            setValueStatusOrderDetail(subCate, ps);
            if (ps != null) {
                ps.setObject(2, id);
            }
            check = setValueStatusOrderDetail(subCate, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE status_order_detail SET deleted =1 WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
