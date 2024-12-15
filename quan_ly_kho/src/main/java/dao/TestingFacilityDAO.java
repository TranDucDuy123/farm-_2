package dao;

import model.TestingFacility;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestingFacilityDAO {

    // Sử dụng Singleton cho lớp TestingFacilityDAO
    public static TestingFacilityDAO getInstance() {
        return new TestingFacilityDAO();
    }

    // Thêm cơ sở khảo nghiệm
    public int insert(TestingFacility facility) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO testing_facility (facility_name, address, district_id, commune_id, contact_person, contact_phone) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, facility.getFacilityName());
            pst.setString(2, facility.getAddress());
            pst.setInt(3, facility.getDistrictId());
            pst.setInt(4, facility.getCommuneId());
            pst.setString(5, facility.getContactPerson());
            pst.setString(6, facility.getContactPhone());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Xóa cơ sở khảo nghiệm theo ID
    public int delete(int facilityId) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM testing_facility WHERE facility_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, facilityId);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Cập nhật thông tin cơ sở khảo nghiệm
    public int update(TestingFacility facility) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE testing_facility SET facility_name = ?, address = ?, district_id = ?, commune_id = ?, contact_person = ?, contact_phone = ? WHERE facility_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, facility.getFacilityName());
            pst.setString(2, facility.getAddress());
            pst.setInt(3, facility.getDistrictId());
            pst.setInt(4, facility.getCommuneId());
            pst.setString(5, facility.getContactPerson());
            pst.setString(6, facility.getContactPhone());
            pst.setInt(7, facility.getFacilityId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Lấy tất cả cơ sở khảo nghiệm
    public List<TestingFacility> selectAll() {
        List<TestingFacility> facilityList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM testing_facility";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TestingFacility facility = new TestingFacility(
                        rs.getInt("facility_id"),
                        rs.getString("facility_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("contact_person"),
                        rs.getString("contact_phone")
                );
                facilityList.add(facility);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facilityList;
    }

    // Lấy cơ sở khảo nghiệm theo ID
    public TestingFacility selectById(int facilityId) {
        TestingFacility facility = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM testing_facility WHERE facility_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, facilityId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                facility = new TestingFacility(
                        rs.getInt("facility_id"),
                        rs.getString("facility_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("contact_person"),
                        rs.getString("contact_phone")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facility;
    }

    // Tìm kiếm cơ sở khảo nghiệm theo huyện
    public List<TestingFacility> searchByDistrict(int districtId) {
        List<TestingFacility> facilityList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM testing_facility WHERE district_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, districtId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TestingFacility facility = new TestingFacility(
                        rs.getInt("facility_id"),
                        rs.getString("facility_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("contact_person"),
                        rs.getString("contact_phone")
                );
                facilityList.add(facility);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facilityList;
    }

    // Tìm kiếm cơ sở khảo nghiệm theo xã
    public List<TestingFacility> searchByCommune(int communeId) {
        List<TestingFacility> facilityList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM testing_facility WHERE commune_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, communeId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TestingFacility facility = new TestingFacility(
                        rs.getInt("facility_id"),
                        rs.getString("facility_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("contact_person"),
                        rs.getString("contact_phone")
                );
                facilityList.add(facility);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TestingFacilityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facilityList;
    }
}
