package controller;

import dao.VeterinaryDepartmentDAO;
import model.VeterinaryDepartment;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchVeterinaryDepartment {

    // Tìm kiếm theo tên chi cục thú y
    public List<VeterinaryDepartment> searchByName(String name) {
        return filterByCondition(dept -> dept.getName() != null &&
                dept.getName().toLowerCase().contains(name.trim().toLowerCase()));
    }

    // Tìm kiếm theo người liên hệ (email)
    public List<VeterinaryDepartment> searchByEmail(String email) {
        return filterByCondition(dept -> dept.getEmail() != null &&
                dept.getEmail().toLowerCase().contains(email.trim().toLowerCase()));
    }

    // Tìm kiếm theo số điện thoại
    public List<VeterinaryDepartment> searchByPhone(String phone) {
        return filterByCondition(dept -> dept.getPhone() != null &&
                dept.getPhone().trim().equals(phone.trim()));
    }

    // Tìm kiếm theo khu vực
    public List<VeterinaryDepartment> searchByRegion(String region) {
        return filterByCondition(dept -> dept.getRegion() != null &&
                dept.getRegion().toLowerCase().contains(region.trim().toLowerCase()));
    }

    // Phương thức chung để lọc danh sách dựa trên điều kiện linh hoạt
    private List<VeterinaryDepartment> filterByCondition(Predicate<VeterinaryDepartment> condition) {
        return VeterinaryDepartmentDAO.getInstance()
                .selectAll()
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
