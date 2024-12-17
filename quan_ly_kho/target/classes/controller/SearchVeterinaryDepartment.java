package controller;

import dao.VeterinaryDepartmentDAO;
import model.VeterinaryDepartment;

import java.util.ArrayList;
import java.util.List;

public class SearchVeterinaryDepartment {

    public List<VeterinaryDepartment> searchByName(String name) {
        List<VeterinaryDepartment> resultList = new ArrayList<>();
        for (VeterinaryDepartment dept : VeterinaryDepartmentDAO.getInstance().selectAll()) {
            if (dept.getDepartmentName().toLowerCase().contains(name.toLowerCase())) {
                resultList.add(dept);
            }
        }
        return resultList;
    }

    public List<VeterinaryDepartment> searchByContactPerson(String contactPerson) {
        List<VeterinaryDepartment> resultList = new ArrayList<>();
        for (VeterinaryDepartment dept : VeterinaryDepartmentDAO.getInstance().selectAll()) {
            if (dept.getContactPerson().toLowerCase().contains(contactPerson.toLowerCase())) {
                resultList.add(dept);
            }
        }
        return resultList;
    }

    public List<VeterinaryDepartment> searchByPhone(String phone) {
        List<VeterinaryDepartment> resultList = new ArrayList<>();
        for (VeterinaryDepartment dept : VeterinaryDepartmentDAO.getInstance().selectAll()) {
            if (dept.getContactPhone().equals(phone)) {
                resultList.add(dept);
            }
        }
        return resultList;
    }
}
