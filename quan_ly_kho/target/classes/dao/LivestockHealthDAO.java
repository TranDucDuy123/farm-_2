package dao;

import model.LivestockHealth;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivestockHealthDAO {

    // Singleton Instance
    private static LivestockHealthDAO instance;

    public static LivestockHealthDAO getInstance() {
        if (instance == null) {
            instance = new LivestockHealthDAO();
        }
        return instance;
    }

    // Insert: Thêm thông tin mới vào bảng
    public int insert(LivestockHealth health) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO livestock_health (farm_id, disease_name, reported_date, resolved_date, status, comments) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, health.getFarmId());
            pst.setString(2, health.getDiseaseName());
            pst.setString(3, health.getReportedDate());
            pst.setString(4, health.getResolvedDate());
            pst.setString(5, health.getStatus());
            pst.setString(6, health.getComments());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Update: Cập nhật thông tin dịch bệnh
    public int update(LivestockHealth health) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "UPDATE livestock_health SET farm_id=?, disease_name=?, reported_date=?, resolved_date=?, status=?, comments=? " +
                         "WHERE health_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, health.getFarmId());
            pst.setString(2, health.getDiseaseName());
            pst.setString(3, health.getReportedDate());
            pst.setString(4, health.getResolvedDate());
            pst.setString(5, health.getStatus());
            pst.setString(6, health.getComments());
            pst.setInt(7, health.getHealthId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Delete: Xóa thông tin dịch bệnh
    public int delete(int healthId) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM livestock_health WHERE health_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, healthId);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Select All: Lấy tất cả thông tin dịch bệnh
    public List<LivestockHealth> selectAll() {
        List<LivestockHealth> healthList = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM livestock_health";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LivestockHealth health = new LivestockHealth(
                    rs.getInt("health_id"),
                    rs.getInt("farm_id"),
                    rs.getString("disease_name"),
                    rs.getString("reported_date"),
                    rs.getString("resolved_date"),
                    rs.getString("status"),
                    rs.getString("comments")
                );
                healthList.add(health);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return healthList;
    }

    // Select By ID: Lấy thông tin theo health_id
    public LivestockHealth selectById(int healthId) {
        LivestockHealth health = null;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM livestock_health WHERE health_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, healthId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                health = new LivestockHealth(
                    rs.getInt("health_id"),
                    rs.getInt("farm_id"),
                    rs.getString("disease_name"),
                    rs.getString("reported_date"),
                    rs.getString("resolved_date"),
                    rs.getString("status"),
                    rs.getString("comments")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return health;
    }

    // Search By Disease Name: Tìm kiếm theo tên bệnh
    public List<LivestockHealth> searchByDiseaseName(String diseaseName) {
        List<LivestockHealth> resultList = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM livestock_health WHERE disease_name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + diseaseName + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LivestockHealth health = new LivestockHealth(
                    rs.getInt("health_id"),
                    rs.getInt("farm_id"),
                    rs.getString("disease_name"),
                    rs.getString("reported_date"),
                    rs.getString("resolved_date"),
                    rs.getString("status"),
                    rs.getString("comments")
                );
                resultList.add(health);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultList;
    }

    // Search By Status: Tìm kiếm theo trạng thái bệnh
    public List<LivestockHealth> searchByStatus(String status) {
        List<LivestockHealth> resultList = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "SELECT * FROM livestock_health WHERE status=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LivestockHealth health = new LivestockHealth(
                    rs.getInt("health_id"),
                    rs.getInt("farm_id"),
                    rs.getString("disease_name"),
                    rs.getString("reported_date"),
                    rs.getString("resolved_date"),
                    rs.getString("status"),
                    rs.getString("comments")
                );
                resultList.add(health);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultList;
    }
}
