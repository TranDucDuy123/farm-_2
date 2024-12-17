package dao;

import model.LivestockHealth;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivestockHealthDAO {

    public static LivestockHealthDAO getInstance() {
        return new LivestockHealthDAO();
    }

    // Insert
    public int insert(LivestockHealth health) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "INSERT INTO livestock_health (farm_id, disease_name, reported_date, resolved_date, status, comments) VALUES (?, ?, ?, ?, ?, ?)";
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

    // Select All
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
}
