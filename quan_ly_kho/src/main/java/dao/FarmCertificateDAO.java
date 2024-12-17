package dao;

import model.FarmCertificate;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmCertificateDAO {

    public static FarmCertificateDAO getInstance() {
        return new FarmCertificateDAO();
    }

    // Insert
    public int insert(FarmCertificate certificate) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO farm_certificates (farm_id, certificate_type, issue_date, expiry_date, issuer, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, certificate.getFarmId());
            pst.setString(2, certificate.getCertificateType());
            pst.setString(3, certificate.getIssueDate());
            pst.setString(4, certificate.getExpiryDate());
            pst.setString(5, certificate.getIssuer());
            pst.setInt(6, certificate.getStatus());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmCertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Select All
    public List<FarmCertificate> selectAll() {
        List<FarmCertificate> certificateList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM farm_certificates";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                FarmCertificate certificate = new FarmCertificate(
                    rs.getInt("certificate_id"),
                    rs.getInt("farm_id"),
                    rs.getString("certificate_type"),
                    rs.getString("issue_date"),
                    rs.getString("expiry_date"),
                    rs.getString("issuer"),
                    rs.getInt("status")
                );
                certificateList.add(certificate);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(FarmCertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return certificateList;
    }
}
