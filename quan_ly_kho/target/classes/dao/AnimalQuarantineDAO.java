package dao;

import model.AnimalQuarantine;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalQuarantineDAO {
    private static AnimalQuarantineDAO instance;

    public static AnimalQuarantineDAO getInstance() {
        if (instance == null) instance = new AnimalQuarantineDAO();
        return instance;
    }

    // INSERT
    public int insert(AnimalQuarantine aq) {
        String sql = "INSERT INTO animal_quarantine (location_name, address, capacity, status) VALUES (?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, aq.getLocationName());
            pst.setString(2, aq.getAddress());
            pst.setInt(3, aq.getCapacity());
            pst.setString(4, aq.getStatus());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // UPDATE
    public int update(AnimalQuarantine aq) {
        String sql = "UPDATE animal_quarantine SET location_name = ?, address = ?, capacity = ?, status = ? WHERE id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, aq.getLocationName());
            pst.setString(2, aq.getAddress());
            pst.setInt(3, aq.getCapacity());
            pst.setString(4, aq.getStatus());
            pst.setInt(5, aq.getQuarantineId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM animal_quarantine WHERE id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // SELECT ALL
    public List<AnimalQuarantine> selectAll() {
        List<AnimalQuarantine> list = new ArrayList<>();
        String sql = "SELECT * FROM animal_quarantine";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(new AnimalQuarantine(
                        rs.getInt("id"),
                        rs.getString("location_name"),
                        rs.getString("address"),
                        rs.getInt("capacity"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // SELECT BY ID
    public AnimalQuarantine selectById(int id) {
        String sql = "SELECT * FROM animal_quarantine WHERE id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new AnimalQuarantine(
                        rs.getInt("id"),
                        rs.getString("location_name"),
                        rs.getString("address"),
                        rs.getInt("capacity"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // SEARCH BY LOCATION NAME
    public List<AnimalQuarantine> searchByLocationName(String name) {
        List<AnimalQuarantine> list = new ArrayList<>();
        String sql = "SELECT * FROM animal_quarantine WHERE location_name LIKE ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new AnimalQuarantine(
                        rs.getInt("id"),
                        rs.getString("location_name"),
                        rs.getString("address"),
                        rs.getInt("capacity"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
