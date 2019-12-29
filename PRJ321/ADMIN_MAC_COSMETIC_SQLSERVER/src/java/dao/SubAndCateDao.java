/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SubAndCate;
import entity.SubCate;
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
public class SubAndCateDao {

    private SubAndCate getValueSubCate(ResultSet rs) {
        try {
            return SubAndCate.builder()
                    .id(rs.getInt(1))
                    .subCateCode(rs.getString(2))
                    .subCateName(rs.getString(3))
                    .categoryName(rs.getString(4))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SubAndCate> getAll() {
        String query = "SELECT sub_category.id,sub_category.sub_category_code,sub_category_name,category_name\n"
                + "FROM categories,sub_category\n"
                + "WHERE categories.id=sub_category.category_id\n"
                + "AND categories.deleted=0\n"
                + "AND sub_category.deleted=0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) // Chuẩn bị câu query
        {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<SubAndCate> list = new ArrayList<>();
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
    public static void main(String[] args) {
        System.out.println(new SubAndCateDao().getAll());
    }
}
