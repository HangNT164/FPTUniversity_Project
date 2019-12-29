/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Card;
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
public class CardDao {

    /**
     * Cart to process
     *
     * @param accountDetailID with accountDetail ID of user
     * @return list cart to buy with each account
     */
    public List<Card> getAllCartByAccountDetailID(int accountDetailID) {
        String query = "  SELECT image_link,product_name,quantity,sell_price*quantity,create_date\n"
                + "  FROM order_detail,orders,images\n"
                + "  WHERE order_detail.order_id=orders.id\n"
                + "  AND images.product_id=order_detail.product_id\n"
                + "  AND order_detail.status_order_detail_id=1\n"
                + "  AND orders.deleted=0\n"
                + "  AND images.cover=1\n"
                + "  AND order_detail.deleted=0\n"
                + "  AND images.deleted=0\n"
                + "  AND account_detail_id= ?";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<Card> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(Card.builder()
                            .imageLink(rs.getString(1))
                            .productName(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .totalPrice(rs.getInt(4))
                            .createDate(rs.getString(5))
                            .build()
                    );
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Cart to process
     *
     * @param accountDetailID with accountDetail ID of user
     * @return list cart to buy with each account
     */
    public List<Card> getAllCartTransportedByAccountDetailID(int accountDetailID) {
        String query = "  SELECT image_link,product_name,quantity,sell_price*quantity,create_date\n"
                + "  FROM order_detail,orders,images\n"
                + "  WHERE order_detail.order_id=orders.id\n"
                + "  AND images.product_id=order_detail.product_id\n"
                + "  AND order_detail.status_order_detail_id=2\n"
                + "  AND orders.deleted=0\n"
                + "  AND images.cover=1\n"
                + "  AND order_detail.deleted=0\n"
                + "  AND images.deleted=0\n"
                + "  AND account_detail_id= ?";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<Card> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(Card.builder()
                            .imageLink(rs.getString(1))
                            .productName(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .totalPrice(rs.getInt(4))
                            .build()
                    );
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Cart to process
     *
     * @param accountDetailID with accountDetail ID of user
     * @return list cart to buy with each account
     */
    public List<Card> getAllCartSuccessByAccountDetailID(int accountDetailID) {
        String query = "  SELECT image_link,product_name,quantity,sell_price*quantity,create_date\n"
                + "  FROM order_detail,orders,images\n"
                + "  WHERE order_detail.order_id=orders.id\n"
                + "  AND images.product_id=order_detail.product_id\n"
                + "  AND order_detail.status_order_detail_id=3\n"
                + "  AND orders.deleted=0\n"
                + "  AND images.cover=1\n"
                + "  AND order_detail.deleted=0\n"
                + "  AND images.deleted=0\n"
                + "  AND account_detail_id= ?";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<Card> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(Card.builder()
                            .imageLink(rs.getString(1))
                            .productName(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .totalPrice(rs.getInt(4))
                            .build()
                    );
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    // get-all
    public List<Card> getAll() {
        String query = "SELECT orders.id,product_name,quantity,sell_price*quantity,create_date,orders.status_order_id\n"
                + "               FROM order_detail,orders,images\n"
                + "               WHERE order_detail.order_id=orders.id\n"
                + "               AND images.product_id=order_detail.product_id\n"
                + "               AND orders.deleted=0\n"
                + "               AND images.cover=1\n"
                + "               AND order_detail.deleted=0\n"
                + "               AND images.deleted=0";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Card> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(Card.builder()
                            .orderID(rs.getInt(1))
                            .productName(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .totalPrice(rs.getInt(4))
                            .createDate(rs.getString(5))
                            .statusCardID(rs.getInt(6))
                            .build()
                    );
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new CardDao().getAll());
    }

    // get-all
    public List<Card> getAllProcess() {
        String query = "   SELECT product_name,quantity,sell_price*quantity,create_date,status_order_detail_id\n"
                + " FROM order_detail,orders,images\n"
                + " WHERE order_detail.order_id=orders.id\n"
                + " AND images.product_id=order_detail.product_id\n"
                + " AND order_detail.status_order_detail_id=1\n"
                + " AND orders.deleted=0\n"
                + " AND images.cover=1\n"
                + " AND order_detail.deleted=0\n"
                + " AND images.deleted=0";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Card> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(Card.builder()
                            .productName(rs.getString(1))
                            .quantity(rs.getInt(2))
                            .totalPrice(rs.getInt(3))
                            .createDate(rs.getString(4))
                            .statusCardID(rs.getInt(5))
                            .build()
                    );
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
