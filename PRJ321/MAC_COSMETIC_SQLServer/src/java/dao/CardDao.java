/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Card;
import entity.ViewOrder;
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
    public List<ViewOrder> getAllCartByAccountDetailID(int accountDetailID) {
        String query = "select  distinct orders.id,image_link,product.product_name,customer_infor.name,customer_infor.address,order_detail.sell_price*order_detail.quantity,orders.create_date,orders.payment,orders.note\n"
                + "from orders,status_order_detail,customer_infor,images,order_detail,product\n"
                + "where orders.status_order_id=status_order_detail.id\n"
                + "and customer_infor.id=orders.customer_infor_id\n"
                + "and orders.id=order_detail.order_id\n"
                + "and images.product_id=order_detail.product_id\n"
                + "and product.id=order_detail.product_id\n"
                + "and status_order_detail.id=1\n"
                + "and images.cover=1\n"
                + "and orders.deleted=0\n"
                + "and order_detail.deleted=0\n"
                + "and images.deleted=0\n"
                + "and product.deleted=0\n"
                + "and status_order_detail.deleted=0\n"
                + "and customer_infor.deleted=0\n"
                + "and account_detail_id= ?\n";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<ViewOrder> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(ViewOrder.builder()
                            .orderID(rs.getInt(1))
                            .imageLink(rs.getString(2))
                            .productName(rs.getString(3))
                            .customerInofr(rs.getString(4))
                            .customerAddress(rs.getString(5))
                            .total(rs.getInt(6))
                            .createDate(rs.getString(7))
                            .payment(rs.getString(8))
                            .note(rs.getString(9))
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
        System.out.println(new CardDao().getAllCartByAccountDetailID(1));
    }

    /**
     * Cart to process
     *
     * @param accountDetailID with accountDetail ID of user
     * @return list cart to buy with each account
     */
    public List<ViewOrder> getAllCartTransportedByAccountDetailID(int accountDetailID) {
        String query = "select  distinct orders.id,image_link,product.product_name,customer_infor.name,customer_infor.address,order_detail.sell_price*order_detail.quantity,orders.create_date,orders.payment,orders.note\n"
                + "from orders,status_order_detail,customer_infor,images,order_detail,product\n"
                + "where orders.status_order_id=status_order_detail.id\n"
                + "and customer_infor.id=orders.customer_infor_id\n"
                + "and orders.id=order_detail.order_id\n"
                + "and images.product_id=order_detail.product_id\n"
                + "and product.id=order_detail.product_id\n"
                + "and status_order_detail.id=2\n"
                + "and images.cover=1\n"
                + "and orders.deleted=0\n"
                + "and order_detail.deleted=0\n"
                + "and images.deleted=0\n"
                + "and product.deleted=0\n"
                + "and status_order_detail.deleted=0\n"
                + "and customer_infor.deleted=0\n"
                + "and account_detail_id= ?\n";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<ViewOrder> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(ViewOrder.builder()
                            .orderID(rs.getInt(1))
                            .imageLink(rs.getString(2))
                            .productName(rs.getString(3))
                            .customerInofr(rs.getString(4))
                            .customerAddress(rs.getString(5))
                            .total(rs.getInt(6))
                            .createDate(rs.getString(7))
                            .payment(rs.getString(8))
                            .note(rs.getString(9))
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
    public List<ViewOrder> getAllCartSuccessByAccountDetailID(int accountDetailID) {
        String query = "select  distinct orders.id,image_link,product.product_name,customer_infor.name,customer_infor.address,order_detail.sell_price*order_detail.quantity,orders.create_date,orders.payment,orders.note\n"
                + "from orders,status_order_detail,customer_infor,images,order_detail,product\n"
                + "where orders.status_order_id=status_order_detail.id\n"
                + "and customer_infor.id=orders.customer_infor_id\n"
                + "and orders.id=order_detail.order_id\n"
                + "and images.product_id=order_detail.product_id\n"
                + "and product.id=order_detail.product_id\n"
                + "and status_order_detail.id=3\n"
                + "and images.cover=1\n"
                + "and orders.deleted=0\n"
                + "and order_detail.deleted=0\n"
                + "and images.deleted=0\n"
                + "and product.deleted=0\n"
                + "and status_order_detail.deleted=0\n"
                + "and customer_infor.deleted=0\n"
                + "and account_detail_id= ?\n";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<ViewOrder> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(ViewOrder.builder()
                            .orderID(rs.getInt(1))
                            .imageLink(rs.getString(2))
                            .productName(rs.getString(3))
                            .customerInofr(rs.getString(4))
                            .customerAddress(rs.getString(5))
                            .total(rs.getInt(6))
                            .createDate(rs.getString(7))
                            .payment(rs.getString(8))
                            .note(rs.getString(9))
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
