//package controller;
//
//import dao.VeterinaryAgencyDAO;
//import model.VeterinaryAgency;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class SearchVeterinaryAgency {
//
//    // Tìm kiếm theo tên agency
//    public List<VeterinaryAgency> searchByAgencyName(String agencyName) {
//        return filterByCondition(agency ->
//                agency.getName().toLowerCase().contains(agencyName.trim().toLowerCase()));
//    }
//
//    // Tìm kiếm theo địa chỉ
//    public List<VeterinaryAgency> searchByAddress(String address) {
//        return filterByCondition(agency ->
//                agency.getAddress().toLowerCase().contains(address.trim().toLowerCase()));
//    }
//
//    // Tìm kiếm theo số điện thoại
//    public List<VeterinaryAgency> searchByPhone(String phone) {
//        return filterByCondition(agency ->
//                agency.getPhone().trim().equals(phone.trim()));
//    }
//
//    // Tìm kiếm theo khu vực (region)
//    public List<VeterinaryAgency> searchByRegion(String region) {
//        return filterByCondition(agency ->
//                agency.getRegion().toLowerCase().contains(region.trim().toLowerCase()));
//    }
//
//    // Phương thức lọc chung sử dụng Predicate
//    private List<VeterinaryAgency> filterByCondition(Predicate<VeterinaryAgency> condition) {
//        return VeterinaryAgencyDAO.getInstance().selectAll()
//                .stream()
//                .filter(condition)
//                .collect(Collectors.toList());
//    }
//}