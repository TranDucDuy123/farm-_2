package controller;

import dao.AnimalQuarantineDAO;
import model.AnimalQuarantine;

import java.util.ArrayList;
import java.util.List;

public class SearchAnimalQuarantine {

    public List<AnimalQuarantine> searchByLocationName(String locationName) {
        List<AnimalQuarantine> resultList = new ArrayList<>();
        for (AnimalQuarantine aq : AnimalQuarantineDAO.getInstance().selectAll()) {
            if (aq.getLocationName().toLowerCase().contains(locationName.toLowerCase())) {
                resultList.add(aq);
            }
        }
        return resultList;
    }

    public List<AnimalQuarantine> searchByCapacity(int capacity) {
        List<AnimalQuarantine> resultList = new ArrayList<>();
        for (AnimalQuarantine aq : AnimalQuarantineDAO.getInstance().selectAll()) {
            if (aq.getCapacity() >= capacity) { // Lọc các nơi có sức chứa lớn hơn hoặc bằng
                resultList.add(aq);
            }
        }
        return resultList;
    }

    public List<AnimalQuarantine> searchByStatus(String status) {
        List<AnimalQuarantine> resultList = new ArrayList<>();
        for (AnimalQuarantine aq : AnimalQuarantineDAO.getInstance().selectAll()) {
            if (aq.getStatus().equalsIgnoreCase(status)) {
                resultList.add(aq);
            }
        }
        return resultList;
    }
}
