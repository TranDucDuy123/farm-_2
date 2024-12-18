package dao;

import model.Slaughterhouse;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlaughterhouseDAO {
    private static SlaughterhouseDAO instance;

    public static SlaughterhouseDAO getInstance() {
        if (instance == null) instance = new SlaughterhouseDAO();
        return instance;
    }

    private final Logger logger = Logger.getLogger(SlaughterhouseDAO.class.getName());

    // Phương thức thực thi chung cho INSERT và UPDATE
    private int executeUpdate(String sql, Slaughterhouse sh, boolean isUpdate) {
        int result = 0;
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, sh.getName());
            pst.setString(2, sh.getAddress());
            pst.setString(3, sh.getPhone());
            pst.setString(4, sh.getType());
            pst.setInt(5, sh.getCapacity());
            pst.setString(6, sh.getStatus());
            if (isUpdate) pst.setInt(7, sh.getId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error executing update: ", e);
        }
        return result;
    }

    // Thêm mới
    public int insert(Slaughterhouse sh) {
        String sql = "INSERT INTO slaughterhouse (name, address, phone, type, capacity, status) VALUES (?, ?, ?, ?, ?, ?)";
        return executeUpdate(sql, sh, false);
    }

    // Cập nhật
    public int update(Slaughterhouse sh) {
        String sql = "UPDATE slaughterhouse SET name=?, address=?, phone=?, type=?, capacity=?, status=? WHERE id=?";
        return executeUpdate(sql, sh, true);
    }

    // Xóa
    public int delete(int id) {
        String sql = "DELETE FROM slaughterhouse WHERE id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            return pst.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting slaughterhouse: ", e);
        }
        return 0;
    }

    // Lấy tất cả dữ liệu
    public List<Slaughterhouse> selectAll() {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToModel(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error selecting all slaughterhouses: ", e);
        }
        return list;
    }

    // Lấy thông tin theo ID
    public Slaughterhouse selectById(int id) {
        String sql = "SELECT * FROM slaughterhouse WHERE id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return mapResultSetToModel(rs);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error selecting slaughterhouse by ID: ", e);
        }
        return null;
    }

    // Tìm kiếm theo loại (type)
    public List<Slaughterhouse> searchByType(String type) {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse WHERE type=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToModel(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error searching slaughterhouse by type: ", e);
        }
        return list;
    }

    // Tìm kiếm theo trạng thái (status)
    public List<Slaughterhouse> searchByStatus(String status) {
        List<Slaughterhouse> list = new ArrayList<>();
        String sql = "SELECT * FROM slaughterhouse WHERE status=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToModel(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error searching slaughterhouse by status: ", e);
        }
        return list;
    }

    // Ánh xạ ResultSet thành đối tượng model
    private Slaughterhouse mapResultSetToModel(ResultSet rs) throws SQLException {
        return new Slaughterhouse(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("phone"),
            rs.getString("type"),
            rs.getInt("capacity"),
            rs.getString("status")
        );
    }
}
