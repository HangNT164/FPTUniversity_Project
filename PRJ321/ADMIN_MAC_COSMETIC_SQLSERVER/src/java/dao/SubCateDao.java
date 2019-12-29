/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SubCate;

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
public class SubCateDao implements ICommonDao<SubCate> {

    private SubCate getValueSubCate(ResultSet rs) {
        try {
            return SubCate.builder()
                    .id(rs.getInt(1))
                    .subCategoryCode(rs.getString(2))
                    .categoryId(rs.getInt(3))
                    .subCateName(rs.getString(4))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueSubCate(SubCate subCate, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, subCate.getSubCategoryCode());
                ps.setObject(2, subCate.getCategoryId());
                ps.setObject(3, subCate.getSubCateName());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<SubCate> getAll() {
        String query = "SELECT * FROM sub_category WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<SubCate> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueSubCate(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SubCate getOne(int id) {
        String query = "SELECT * FROM sub_category WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueSubCate(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(SubCate subCate) {
        int check = 0;
        String query = "INSERT INTO sub_category(sub_category_code,category_id ,sub_category_name)"
                + "VALUES(?, ?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueSubCate(subCate, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, SubCate subCate) {
        int check = 0;
        String query = "UPDATE sub_category SET category_id = ?, sub_category_name = ? WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ps.setObject(1, subCate.getCategoryId());
                ps.setObject(2, subCate.getSubCateName());
                ps.setObject(3, id);
            }
            check =ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE sub_category SET deleted =1 WHERE id = ?";

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
    public boolean isDulicate(List<SubCate>lists,String subCode){
        for(SubCate s:lists){
            if(s.getSubCategoryCode().equalsIgnoreCase(subCode)){
                return false;
            }
        }
        return true;
    }
}
