/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Card;
import entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class OrderDetailDao implements ICommonDao<OrderDetail>, OrderDetailCommonDao {

    private OrderDetail getValueOrderDetail(ResultSet rs) {
        try {
            return OrderDetail.builder()
                    .id(rs.getInt(1))
                    .orderId(rs.getInt(2))
                    .productId(rs.getInt(3))
                    .productName(rs.getString(4))
                    .sellPrice(rs.getInt(5))
                    .orginPrice(rs.getInt(6))
                    .quantity(rs.getInt(7))
                    .deleted(rs.getBoolean(8))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueOrderDetail(OrderDetail orderDetail, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, orderDetail.getOrderId());
                ps.setObject(2, orderDetail.getProductId());
                ps.setObject(3, orderDetail.getProductName());
                ps.setObject(4, orderDetail.getSellPrice());
                ps.setObject(5, orderDetail.getOrginPrice());
                ps.setObject(6, orderDetail.getQuantity());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<OrderDetail> getAll() {
        String query = "SELECT * FROM order_detail WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<OrderDetail> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueOrderDetail(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public OrderDetail getOne(int id) {
        String query = "SELECT * FROM order_detail WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueOrderDetail(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(OrderDetail orderDetail) {
        int check = 0;
        String query = "INSERT INTO order_detail (order_id, product_id, "
                + "product_name, sell_price,orgin_price, quantity)"
                + "VALUES(?,?,?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueOrderDetail(orderDetail, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public OrderDetail getOrderDetailByOrder(int id) {
        String query = "SELECT order_detail.*\n"
                + "                 FROM orders,order_detail\n"
                + "                 WHERE orders.id=order_detail.order_id\n"
                + "                 AND orders.id=? AND orders.deleted =0 AND order_detail.deleted=0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueOrderDetail(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addListCard(List<Card> list, int orderID) {
        String query = "INSERT INTO order_detail (order_id, product_id, "
                + "product_name, sell_price,orgin_price, quantity)"
                + "VALUES(?,?,?,?,?,?)";

        int[] arr = {};
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (Card c : list) {
                    ps.setObject(1, orderID);
                    ps.setObject(2, c.getId());
                    ps.setObject(3, c.getProductName());
                    ps.setObject(4, c.getSellPrice());
                    ps.setObject(5, c.getOrginPrice());
                    ps.setObject(6, c.getQuantity());

                    //batch update
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        int check = 0;
        String query = "UPDATE order_detail SET order_id = ?,product_id = ?,product_name=?,"
                + "sell_price=?,orgin_price=?,quantity=?  WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueOrderDetail(orderDetail, ps);
            if (ps != null) {
                ps.setObject(7, id);
            }
            check = setValueOrderDetail(orderDetail, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE  order_detail SET deleted =1 WHERE order_id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
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
