package dao;

import model.VeterinaryAgency;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinaryAgencyDAO {
    // Singleton
    private static VeterinaryAgencyDAO instance;

    public static VeterinaryAgencyDAO getInstance() {
        if (instance == null) instance = new VeterinaryAgencyDAO();
        return instance;
    }

    // INSERT: Thêm mới
    public int insert(VeterinaryAgency agency) {
        String sql = "INSERT INTO veterinary_agency (agency_name, address, contact_person, contact_phone) VALUES (?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, agency.getAgencyName());
            pst.setString(2, agency.getAddress());
            pst.setString(3, agency.getContactPerson());
            pst.setString(4, agency.getContactPhone());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // UPDATE: Cập nhật thông tin
    public int update(VeterinaryAgency agency) {
        String sql = "UPDATE veterinary_agency SET agency_name=?, address=?, contact_person=?, contact_phone=? WHERE agency_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, agency.getAgencyName());
            pst.setString(2, agency.getAddress());
            pst.setString(3, agency.getContactPerson());
            pst.setString(4, agency.getContactPhone());
            pst.setInt(5, agency.getAgencyId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // DELETE: Xóa bản ghi theo ID
    public int delete(int agencyId) {
        String sql = "DELETE FROM veterinary_agency WHERE agency_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, agencyId);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // SELECT ALL: Lấy tất cả thông tin
    public List<VeterinaryAgency> selectAll() {
        List<VeterinaryAgency> agencies = new ArrayList<>();
        String sql = "SELECT * FROM veterinary_agency";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                agencies.add(new VeterinaryAgency(
                    rs.getInt("agency_id"),
                    rs.getString("agency_name"),
                    rs.getString("address"),
                    rs.getString("contact_person"),
                    rs.getString("contact_phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agencies;
    }

    // SELECT BY ID: Lấy thông tin theo ID
    public VeterinaryAgency selectById(int agencyId) {
        String sql = "SELECT * FROM veterinary_agency WHERE agency_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, agencyId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new VeterinaryAgency(
                    rs.getInt("agency_id"),
                    rs.getString("agency_name"),
                    rs.getString("address"),
                    rs.getString("contact_person"),
                    rs.getString("contact_phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // SEARCH BY NAME: Tìm kiếm theo tên
    public List<VeterinaryAgency> searchByName(String name) {
        List<VeterinaryAgency> agencies = new ArrayList<>();
        String sql = "SELECT * FROM veterinary_agency WHERE agency_name LIKE ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                agencies.add(new VeterinaryAgency(
                    rs.getInt("agency_id"),
                    rs.getString("agency_name"),
                    rs.getString("address"),
                    rs.getString("contact_person"),
                    rs.getString("contact_phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agencies;
    }
}
