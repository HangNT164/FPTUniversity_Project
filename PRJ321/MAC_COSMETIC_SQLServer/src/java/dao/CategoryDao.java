/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;

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
public class CategoryDao implements ICommonDao<Category> {

    private Category getValueCategory(ResultSet rs) {
        try {
            return Category.builder()
                    .id(rs.getInt(1))
                    .categoryCode(rs.getString(2))
                    .categoryName(rs.getString(3))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueCategory(Category category, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, category.getCategoryCode());
                ps.setObject(2, category.getCategoryName());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Category> getAll() {
        String query = "SELECT * FROM categories WHERE deleted =0";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Category> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueCategory(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Category getOne(int id) {
        String query = "SELECT * FROM categories where id = ? AND deleted =0";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueCategory(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Category category) {
        int check = 0;
        String query = "INSERT INTO categories(category_code,category_name)"
                + "VALUES(?,?)";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueCategory(category, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Category category) {
        int check = 0;
        String query = "UPDATE categories SET category_name = ? WHERE id = ? AND deleted =0 ";
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueCategory(category, ps);
            if (ps != null) {
                ps.setObject(3, id);
            }
            check = setValueCategory(category, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "Update categories SET  deleted =1 WHERE id = ?";
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
