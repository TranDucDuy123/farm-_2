package dao;

import model.Organization;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrganizationDAO {

    public static OrganizationDAO getInstance() {
        return new OrganizationDAO();
    }

    // Insert
    public int insert(Organization org) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO organization (name, contact_person, phone, email, organization_type, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, org.getName());
            pst.setString(2, org.getContactPerson());
            pst.setString(3, org.getPhone());
            pst.setString(4, org.getEmail());
            pst.setString(5, org.getOrganizationType());
            pst.setString(6, org.getStatus());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Delete
    public int delete(int orgId) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM organization WHERE organization_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, orgId);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Update
    public int update(Organization org) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE organization SET name = ?, contact_person = ?, phone = ?, email = ?, organization_type = ?, status = ? WHERE organization_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, org.getName());
            pst.setString(2, org.getContactPerson());
            pst.setString(3, org.getPhone());
            pst.setString(4, org.getEmail());
            pst.setString(5, org.getOrganizationType());
            pst.setString(6, org.getStatus());
            pst.setInt(7, org.getOrganizationId());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Select All
    public List<Organization> selectAll() {
        List<Organization> orgList = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM organization";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Organization org = new Organization(
                    rs.getInt("organization_id"),
                    rs.getString("name"),
                    rs.getString("contact_person"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("organization_type"),
                    rs.getString("status")
                );
                orgList.add(org);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orgList;
    }

    // Select By ID
    public Organization selectById(int orgId) {
        Organization org = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM organization WHERE organization_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, orgId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                org = new Organization(
                    rs.getInt("organization_id"),
                    rs.getString("name"),
                    rs.getString("contact_person"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("organization_type"),
                    rs.getString("status")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(OrganizationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return org;
    }
}