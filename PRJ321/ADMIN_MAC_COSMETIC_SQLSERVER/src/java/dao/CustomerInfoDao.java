/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CustomerInfo;

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
public class CustomerInfoDao implements ICommonDao<CustomerInfo>, CustomerCommonDao {

    private CustomerInfo getValueCustomerInfo(ResultSet rs) {
        try {
            return CustomerInfo.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .mobile(rs.getString(3))
                    .address(rs.getString(4))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueCustomerInfo(CustomerInfo order, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, order.getName());
                ps.setObject(2, order.getMobile());
                ps.setObject(3, order.getAddress());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<CustomerInfo> getAll() {
        String query = "SELECT * FROM [customer_infor] WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<CustomerInfo> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueCustomerInfo(rs));
                }
                return list;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public CustomerInfo getOne(int id) {
        String query = "SELECT * FROM customer_infor  WHERE id = ? AND deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueCustomerInfo(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(CustomerInfo obj) {
        return false;
    }

    @Override
    public int addCustomerReturnId(CustomerInfo order) {
        String query = "INSERT INTO customer_infor(name,mobile,address)"
                + "VALUES(?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {
            if (ps != null) {
                ps.setObject(1, order.getName());
                ps.setObject(2, order.getMobile());
                ps.setObject(3, order.getAddress());
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
    public boolean update(int id, CustomerInfo category) {
        int check = 0;
        String query = "UPDATE customer_infor SET name = ?, mobile = ?,"
                + "address=? WHERE id = ? AND deleted =0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueCustomerInfo(category, ps);
            if (ps != null) {
                ps.setObject(4, id);
            }
            check = setValueCustomerInfo(category, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE customer_infor SET deleted =1  WHERE id = ?";

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
        String query = "DELETE FROM customer_infor WHERE id = ? AND deleted = 0;";

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

    public CustomerInfo getOneByOrderID(int id) {
        String query = "select customer_infor.*\n"
                + "from customer_infor,orders\n"
                + "where customer_infor.id=orders.customer_infor_id\n"
                + "and orders.id=? AND customer_infor.deleted = 0 AND orders.deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueCustomerInfo(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new CustomerInfoDao().getOneByOrderID(3));
    }

}
