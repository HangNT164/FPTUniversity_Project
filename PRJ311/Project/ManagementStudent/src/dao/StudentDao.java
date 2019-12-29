/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Student;
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
public class StudentDao {

    public List<Student> getAll() {
        String sql = "SELECT * FROM student";
        List<Student> listStudent = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listStudent.add(new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Student> getAllByName(String name) {
        String sql = "SELECT * FROM student WHERE name LIKE ?";
        List<Student> listStudent = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listStudent.add(new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Student getOne(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Student student) {
        int check = 0;
        String sql = "INSERT INTO student(roll_number, full_name, gender, email,phone_number,address)"
                + " VALUES(?, ?, ?, ?,?,?)";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, student.getRollNumber());
            ps.setObject(2, student.getFullName());
            ps.setObject(3, student.isGender());
            ps.setObject(4, student.getEmail());
            ps.setObject(5, student.getPhoneNumber());
            ps.setObject(6, student.getAddress());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Student student, int id) {
        int check = 0;
        String sql = "UPDATE student SET full_name=?,gender=?,email=?, "
                + " phone_number= ?,address=? "
                + " WHERE id= ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, student.getFullName());
            ps.setObject(2, student.isGender());
            ps.setObject(3, student.getEmail());
            ps.setObject(4, student.getPhoneNumber());
            ps.setObject(5, student.getAddress());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String rollNumber) {
        int check = 0;
        String sql = "DELETE FROM student WHERE roll_number= ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, rollNumber);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean isDulicapte(String rollNumber) {
        String sql = "SELECT * FROM student WHERE roll_number = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, rollNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<Student> getAllBy(String str, String rollNumber) {
        String sql = "SELECT * FROM student\n"
                + "WHERE " + str + " LIKE ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            List<Student> listResult = new ArrayList<>();
            ps.setString(1, "%" + rollNumber + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listResult.add(new Student(rs.getInt(1),
                         rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return listResult;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        boolean test=new StudentDao().add(new Student("HE130563", "ABC", true,
                "ABC@gmail.com", "01234569620", "AB"));
        System.out.println(test);
    }
}
