/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class OrderDao implements ICommonDao<Order>, OrderCommonDao {

    private Order getValueOrder(ResultSet rs) {
        try {
            return Order.builder()
                    .id(rs.getInt(1))
                    .accountDetailId(rs.getInt(2))
                    .customerInfoId(rs.getInt(3))
                    .statusOrderDetailId(rs.getInt(4))
                    .totalPrice(rs.getInt(5))
                    .note(rs.getString(6))
                    .createDate(rs.getString(7))
                    .shipDate(rs.getString(8))
                    .payment(rs.getString(9))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueOrder(Order category, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, category.getAccountDetailId());
                ps.setObject(2, category.getCustomerInfoId());
                ps.setObject(3, category.getStatusOrderDetailId());
                ps.setObject(4, category.getTotalPrice());
                ps.setObject(5, category.getNote());
                ps.setObject(6, category.getShipDate());
                ps.setObject(7, category.getPayment());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM orders WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Order> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueOrder(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Order getOne(int id) {
        String query = "SELECT * FROM orders WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueOrder(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Order category) {
        return false;
    }

    @Override
    public int addOrderReturnId(Order category) {
        String query = "INSERT INTO orders(account_detail_id,customer_infor_id,total_price,note,ship_date,payment)"
                + "VALUES(?,?,?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {
            if (ps != null) {
                ps.setObject(1, category.getAccountDetailId());
                ps.setObject(2, category.getCustomerInfoId());
                ps.setObject(3, category.getTotalPrice());
                ps.setObject(4, category.getNote());
                ps.setObject(5, category.getShipDate());
                ps.setObject(6, category.getPayment());

                int isCheck = ps.executeUpdate();
                if (isCheck > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    rs.next();
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    @Override
    public boolean update(int id, Order category) {
        int check = 0;
        String query = "UPDATE orders SET account_detail_id=?,customer_info_id = ?,status_order_id=?,total_price = ?,note=?,ship_date =?,payment=?"
                + "WHERE id = ? AND deleted=0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueOrder(category, ps);
            ps.setObject(8, id);
            check = setValueOrder(category, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE orders SET deleted =1 WHERE id = ?";

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

    @Override
    public boolean remove(int id) {
        int check = 0;
        String query = "DELETE FROM orders WHERE id = ? AND deleted =0";

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

    public List<Order> getAllByAccountDetail(int accountDetailID) {
        String query = "SELECT orders.* from orders,account_detail\n"
                + "WHERE orders.account_detail_id=account_detail.id\n"
                + "AND account_detail.id= ?";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, accountDetailID);
                ResultSet rs = ps.executeQuery();
                List<Order> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueOrder(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public int getSumPrice(String month, List<Order> list) {

        int sum = 0;
        for (Order order : list) {
            if (order.getCreateDate().substring(5, 7).equals(month)) {
                sum += order.getTotalPrice();
            }
        }
        return sum;
    }

    public int getSumTienLai(String month, List<Order> list) {
        List<Order> list12 = new ArrayList<>();

        for (Order order : list) {
            if (order.getCreateDate().substring(5, 7).equals("11")) {

                list12.add(order);
            }
        }

        int sum = 0;
        List<OrderDetail> list123 = new OrderDetailDao().getAll();

        for (Order order : list12) {
            for (OrderDetail order1 : list123) {
                if (order.getId() == order1.getOrderId()) {
                    sum += order1.getSellPrice() - order1.getOrginPrice();
                }

            }

        }
        return sum;
    }

    public static void main(String[] args) {
       List<Order> list = new OrderDao().getAll();
        System.out.println(new OrderDao().getSumPrice("12", list));

    }
}
