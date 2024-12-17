package controller;

import dao.LivestockHealthDAO;
import model.LivestockHealth;

import java.util.ArrayList;
import java.util.List;

public class SearchLivestockHealth {

    public List<LivestockHealth> searchByDiseaseName(String diseaseName) {
        List<LivestockHealth> resultList = new ArrayList<>();
        for (LivestockHealth health : LivestockHealthDAO.getInstance().selectAll()) {
            if (health.getDiseaseName().toLowerCase().contains(diseaseName.toLowerCase())) {
                resultList.add(health);
            }
        }
        return resultList;
    }

    public List<LivestockHealth> searchByStatus(String status) {
        List<LivestockHealth> resultList = new ArrayList<>();
        for (LivestockHealth health : LivestockHealthDAO.getInstance().selectAll()) {
            if (health.getStatus().equalsIgnoreCase(status)) {
                resultList.add(health);
            }
        }
        return resultList;
    }

    public List<LivestockHealth> searchByReportedDate(String reportedDate) {
        List<LivestockHealth> resultList = new ArrayList<>();
        for (LivestockHealth health : LivestockHealthDAO.getInstance().selectAll()) {
            if (health.getReportedDate().equals(reportedDate)) {
                resultList.add(health);
            }
        }
        return resultList;
    }
}
