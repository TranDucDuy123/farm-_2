package dao;

import model.Slaughterhouse;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlaughterhouseDAO {
    // Singleton instance
    private static SlaughterhouseDAO instance;

    public static SlaughterhouseDAO getInstance() {
        if (instance == null) instance = new SlaughterhouseDAO();
        return instance;
    }

    private final Logger logger = Logger.getLogger(SlaughterhouseDAO.class.getName());

    // INSERT: Thêm mới dữ liệu
    public int insert(Slaughterhouse sh) {
        String sql = "INSERT INTO slaughterhouse (slaughterhouse_name, address, capacity, contact_person) VALUES (?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, sh.getSlaughterhouseName());
            pst.setString(2, sh.getAddress());
            pst.setInt(3, sh.getCapacity());
            pst.setString(4, sh.getContactPerson());
            return pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error inserting slaughterhouse: ", e);
        }
        return 0;
    }

    // UPDATE: Cập nhật thông tin
    public int update(Slaughterhouse sh) {
        String sql = "UPDATE slaughterhouse SET slaughterhouse_name=?, address=?, capacity=?, contact_person=? WHERE slaughterhouse_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, sh.getSlaughterhouseName());
            pst.setString(2, sh.getAddress());
            pst.setInt(3, sh.getCapacity());
            pst.setString(4, sh.getContactPerson());
            pst.setInt(5, sh.getSlaughterhouseId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating slaughterhouse: ", e);
        }
        return 0;
    }

    // DELETE: Xóa dữ liệu theo ID
    public int delete(int slaughterhouseId) {
        String sql = "DELETE FROM slaughterhouse WHERE slaughterhouse_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, slaughterhouseId);
            return pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting slaughterhouse: ", e);
        }
        return 0;
    }

    // SELECT ALL: Lấy tất cả dữ liệu
    public List<Slaughterhouse> selectAll() {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(new Slaughterhouse(
                    rs.getInt("slaughterhouse_id"),
                    rs.getString("slaughterhouse_name"),
                    rs.getString("address"),
                    rs.getInt("capacity"),
                    rs.getString("contact_person")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving slaughterhouse data: ", e);
        }
        return list;
    }

    // SELECT BY ID: Lấy thông tin theo ID
    public Slaughterhouse selectById(int slaughterhouseId) {
        String sql = "SELECT * FROM slaughterhouse WHERE slaughterhouse_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, slaughterhouseId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Slaughterhouse(
                    rs.getInt("slaughterhouse_id"),
                    rs.getString("slaughterhouse_name"),
                    rs.getString("address"),
                    rs.getInt("capacity"),
                    rs.getString("contact_person")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error retrieving slaughterhouse by ID: ", e);
        }
        return null;
    }

    // SEARCH BY NAME: Tìm kiếm theo tên
    public List<Slaughterhouse> searchByName(String name) {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse WHERE slaughterhouse_name LIKE ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Slaughterhouse(
                    rs.getInt("slaughterhouse_id"),
                    rs.getString("slaughterhouse_name"),
                    rs.getString("address"),
                    rs.getInt("capacity"),
                    rs.getString("contact_person")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error searching slaughterhouse by name: ", e);
        }
        return list;
    }

    // SEARCH BY CAPACITY: Tìm kiếm theo năng lực
    public List<Slaughterhouse> searchByCapacity(int capacity) {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse WHERE capacity >= ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, capacity);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Slaughterhouse(
                    rs.getInt("slaughterhouse_id"),
                    rs.getString("slaughterhouse_name"),
                    rs.getString("address"),
                    rs.getInt("capacity"),
                    rs.getString("contact_person")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error searching slaughterhouse by capacity: ", e);
        }
        return list;
    }
}
