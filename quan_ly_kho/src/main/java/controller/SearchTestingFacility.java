package controller;

import dao.TestingFacilityDAO;
import model.TestingFacility;

import java.util.List;

public class SearchTestingFacility {

    // Tìm cơ sở khảo nghiệm theo tên huyện
    public List<TestingFacility> searchByDistrictId(int districtId) {
        return TestingFacilityDAO.getInstance().searchByDistrict(districtId);
    }

    // Tìm cơ sở khảo nghiệm theo tên xã
    public List<TestingFacility> searchByCommuneId(int communeId) {
        return TestingFacilityDAO.getInstance().searchByCommune(communeId);
    }

    // Lấy tất cả cơ sở khảo nghiệm
    public List<TestingFacility> searchAllFacilities() {
        return TestingFacilityDAO.getInstance().selectAll();
    }

    // Tìm cơ sở khảo nghiệm theo ID
    public TestingFacility searchById(int facilityId) {
        return TestingFacilityDAO.getInstance().selectById(facilityId);
    }
}
