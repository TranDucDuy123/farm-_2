package controller;

import dao.OrganizationDAO;
import model.Organization;

import java.util.ArrayList;
import java.util.List;

public class SearchOrganization {

    private final List<Organization> allOrganizations;

    // Constructor để load dữ liệu từ database
    public SearchOrganization() {
        this.allOrganizations = OrganizationDAO.getInstance().selectAll();
    }

    // Tìm kiếm theo tên tổ chức
    public List<Organization> searchByName(String keyword) {
        refreshData(); // Tự động làm mới dữ liệu
        List<Organization> resultList = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return allOrganizations;
        }
        for (Organization org : allOrganizations) {
            if (org.getName() != null && org.getName().toLowerCase().contains(keyword.trim().toLowerCase())) {
                resultList.add(org);
            }
        }
        return resultList;
    }

    // Tìm kiếm theo loại tổ chức
    public List<Organization> searchByType(String type) {
        refreshData();
        List<Organization> resultList = new ArrayList<>();
        if (type == null || type.trim().isEmpty()) {
            return allOrganizations;
        }
        for (Organization org : allOrganizations) {
            if (org.getOrganizationType() != null && org.getOrganizationType().equalsIgnoreCase(type.trim())) {
                resultList.add(org);
            }
        }
        return resultList;
    }

    // Tìm kiếm theo người liên hệ
    public List<Organization> searchByContactPerson(String contactPerson) {
        refreshData();
        List<Organization> resultList = new ArrayList<>();
        if (contactPerson == null || contactPerson.trim().isEmpty()) {
            return allOrganizations;
        }
        for (Organization org : allOrganizations) {
            if (org.getContactPerson() != null && org.getContactPerson().toLowerCase().contains(contactPerson.trim().toLowerCase())) {
                resultList.add(org);
            }
        }
        return resultList;
    }

    // Tìm kiếm theo trạng thái (Active/Inactive)
    public List<Organization> searchByStatus(int status) {
        refreshData();
        List<Organization> resultList = new ArrayList<>();
        for (Organization org : allOrganizations) {
            if (org.getStatus() == status) {
                resultList.add(org);
            }
        }
        return resultList;
    }

    // Tìm kiếm theo địa chỉ
    public List<Organization> searchByAddress(String address) {
        refreshData();
        List<Organization> resultList = new ArrayList<>();
        if (address == null || address.trim().isEmpty()) {
            return allOrganizations;
        }
        for (Organization org : allOrganizations) {
            if (org.getAddress() != null && org.getAddress().toLowerCase().contains(address.trim().toLowerCase())) {
                resultList.add(org);
            }
        }
        return resultList;
    }

    // Làm mới dữ liệu từ cơ sở dữ liệu
    public void refreshData() {
        allOrganizations.clear();
        allOrganizations.addAll(OrganizationDAO.getInstance().selectAll());
    }
}
