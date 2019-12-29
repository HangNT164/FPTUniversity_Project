package dao;

import controller.BookController;
import entity.Publishers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author langt
 */
public class PublisherDAO {

    List<Publishers> list;

    //SELECT ALL PUBLISHER
    public List<Publishers> selectPub() throws SQLException {
        String sql = "select * from publishers";
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new Vector<>();
        while (rs.next()) {
            String publishID = rs.getString("pub_id");
            String publishName = rs.getString("pub_name");
            String pubAddress = rs.getString("pub_address");
            list.add(new Publishers(publishID, publishName, pubAddress));
        }
        rs.close();
        return list;
    }
    
    public String selectByPublisher(String name) throws SQLException {
        String sql = "select pub_id from publishers where pub_name = '" + name+"'";
        PreparedStatement ps = BookController.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("pub_id"));
        return rs.getString("pub_id");
    }

}
