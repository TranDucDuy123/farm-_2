package dao;

import model.VeterinaryDepartment;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinaryDepartmentDAO {
    private static VeterinaryDepartmentDAO instance;

    public static VeterinaryDepartmentDAO getInstance() {
        if (instance == null) {
            instance = new VeterinaryDepartmentDAO();
        }
        return instance;
    }

    public int insert(VeterinaryDepartment dept) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO veterinary_department (department_name, address, contact_person, contact_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dept.getDepartmentName());
            pst.setString(2, dept.getAddress());
            pst.setString(3, dept.getContactPerson());
            pst.setString(4, dept.getContactPhone());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int update(VeterinaryDepartment dept) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "UPDATE veterinary_department SET department_name=?, address=?, contact_person=?, contact_phone=? WHERE department_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dept.getDepartmentName());
            pst.setString(2, dept.getAddress());
            pst.setString(3, dept.getContactPerson());
            pst.setString(4, dept.getContactPhone());
            pst.setInt(5, dept.getDepartmentId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int delete(int departmentId) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM veterinary_department WHERE department_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, departmentId);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<VeterinaryDepartment> selectAll() {
        List<VeterinaryDepartment> list = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM veterinary_department";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VeterinaryDepartment dept = new VeterinaryDepartment(
                    rs.getInt("department_id"),
                    rs.getString("department_name"),
                    rs.getString("address"),
                    rs.getString("contact_person"),
                    rs.getString("contact_phone")
                );
                list.add(dept);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public VeterinaryDepartment selectById(int departmentId) {
        VeterinaryDepartment dept = null;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM veterinary_department WHERE department_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, departmentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                dept = new VeterinaryDepartment(
                    rs.getInt("department_id"),
                    rs.getString("department_name"),
                    rs.getString("address"),
                    rs.getString("contact_person"),
                    rs.getString("contact_phone")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dept;
    }
}
