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

    // Thêm mới chi cục thú y
    public int insert(VeterinaryDepartment dept) {
        String sql = "INSERT INTO vet_subdepartment (name, address, phone, email, region) VALUES (?, ?, ?, ?, ?)";
        return executeUpdate(sql, dept, false);
    }

    // Cập nhật chi cục thú y
    public int update(VeterinaryDepartment dept) {
        String sql = "UPDATE vet_subdepartment SET name=?, address=?, phone=?, email=?, region=? WHERE id=?";
        return executeUpdate(sql, dept, true);
    }

    // Xóa chi cục thú y theo ID
    public int delete(int departmentId) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM vet_subdepartment WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, departmentId);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Lấy tất cả chi cục thú y
    public List<VeterinaryDepartment> selectAll() {
        List<VeterinaryDepartment> list = new ArrayList<>();
        String sql = "SELECT * FROM vet_subdepartment";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToModel(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    // Lấy chi cục thú y theo ID
    public VeterinaryDepartment selectById(int departmentId) {
        VeterinaryDepartment dept = null;
        String sql = "SELECT * FROM vet_subdepartment WHERE id=?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, departmentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                dept = mapResultSetToModel(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dept;
    }

    // Phương thức thực thi chung cho insert và update
    private int executeUpdate(String sql, VeterinaryDepartment dept, boolean isUpdate) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, dept.getName());
            pst.setString(2, dept.getAddress());
            pst.setString(3, dept.getPhone());
            pst.setString(4, dept.getEmail());
            pst.setString(5, dept.getRegion());
            if (isUpdate) pst.setInt(6, dept.getId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Map dữ liệu từ ResultSet sang model
    private VeterinaryDepartment mapResultSetToModel(ResultSet rs) throws SQLException {
        return new VeterinaryDepartment(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("phone"),
            rs.getString("email"),
            rs.getString("region")
        );
    }
}
