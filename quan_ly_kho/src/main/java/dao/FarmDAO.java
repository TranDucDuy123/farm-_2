package dao;

import model.Farm;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmDAO {

    // Sử dụng Singleton cho lớp FarmDAO
    public static FarmDAO getInstance() {
        return new FarmDAO();
    }

    // Chèn farm mới vào cơ sở dữ liệu
    public int insert(Farm farm) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO farm (farm_name, address, district_id, commune_id, owner) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, farm.getFarmName());
            pst.setString(2, farm.getAddress());
            pst.setInt(3, farm.getDistrictId());
            pst.setInt(4, farm.getCommuneId());
            pst.setString(5, farm.getOwner());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        // Xóa farm theo farm_id
   public int delete(int farmId) {
    int result = 0;
    Connection con = null;
    PreparedStatement pst = null;
    
    try {
        con = JDBCUtil.getConnection();  // Mở kết nối
        String sql = "DELETE FROM farm WHERE farm_id = ?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, farmId);
        
        result = pst.executeUpdate();  // Thực hiện câu lệnh DELETE
    } catch (SQLException ex) {
        Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Đảm bảo đóng tài nguyên sau khi sử dụng
        try {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                JDBCUtil.closeConnection(con);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return result;  // Trả về kết quả
}



    // Cập nhật thông tin farm
    public int update(Farm farm) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE farm SET farmName = ?, address = ?, district_id = ?, commune_id = ?, owner = ? WHERE farm_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, farm.getFarmName());
            pst.setString(2, farm.getAddress());
            pst.setInt(3, farm.getDistrictId());
            pst.setInt(4, farm.getCommuneId());
            pst.setString(5, farm.getOwner());
            pst.setInt(6, farm.getFarmId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Lấy tất cả farm
    public List<Farm> selectAll() {
        List<Farm> farmList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM farm";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm(
                        rs.getInt("farm_id"),
                        rs.getString("farm_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("owner")
                );
                farmList.add(farm);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmList;
    }
    
        // Lấy farm theo farm_id
    public Farm selectById(int farmId) {
        Farm farm = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM farm WHERE farm_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, farmId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                farm = new Farm(
                        rs.getInt("farm_id"),
                        rs.getString("farm_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("owner")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farm;
    }
 // Phương thức tìm kiếm farm theo tên huyện
    public ArrayList<Farm> searchByDistrictName(String districtName) {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT f.farm_id, f.farm_name, f.address, f.district_id, f.commune_id, f.owner " +
                         "FROM farm f " +
                         "JOIN district d ON f.district_id = d.district_id " +
                         "WHERE d.district_name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + districtName + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm();
                farm.setFarmId(rs.getInt("farm_id"));
                farm.setFarmName(rs.getString("farm_name"));
                farm.setAddress(rs.getString("address"));
                farm.setDistrictId(rs.getInt("district_id"));
                farm.setCommuneId(rs.getInt("commune_id"));
                farm.setOwner(rs.getString("owner"));
                farms.add(farm);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return farms;
    }

    // Phương thức tìm kiếm farm theo tên xã
    public ArrayList<Farm> searchByCommuneName(String communeName) {
        ArrayList<Farm> farms = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT f.farm_id, f.farm_name, f.address, f.district_id, f.commune_id, f.owner " +
                         "FROM farm f " +
                         "JOIN commune c ON f.commune_id = c.commune_id " +
                         "WHERE c.commune_name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + communeName + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm();
                farm.setFarmId(rs.getInt("farm_id"));
                farm.setFarmName(rs.getString("farm_name"));
                farm.setAddress(rs.getString("address"));
                farm.setDistrictId(rs.getInt("district_id"));
                farm.setCommuneId(rs.getInt("commune_id"));
                farm.setOwner(rs.getString("owner"));
                farms.add(farm);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return farms;
    }
    // Tìm farm theo huyện (district_id)
    public List<Farm> searchByDistrict(int districtId) {
        List<Farm> farmList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM farm WHERE district_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, districtId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm(
                        rs.getInt("farm_id"),
                        rs.getString("farm_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("owner")
                );
                farmList.add(farm);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmList;
    }

    // Tìm farm theo xã (commune_id)
    public List<Farm> searchByCommune(int communeId) {
        List<Farm> farmList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM farm WHERE commune_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, communeId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Farm farm = new Farm(
                        rs.getInt("farm_id"),
                        rs.getString("farm_name"),
                        rs.getString("address"),
                        rs.getInt("district_id"),
                        rs.getInt("commune_id"),
                        rs.getString("owner")
                );
                farmList.add(farm);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farmList;
    }
    
}
