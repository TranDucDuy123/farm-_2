package controller;

import dao.SlaughterhouseDAO;
import model.Slaughterhouse;

import java.util.ArrayList;
import java.util.List;

public class SearchSlaughterhouse {

    public List<Slaughterhouse> searchByName(String slaughterhouseName) {
        List<Slaughterhouse> resultList = new ArrayList<>();
        for (Slaughterhouse sh : SlaughterhouseDAO.getInstance().selectAll()) {
            if (sh.getSlaughterhouseName().toLowerCase().contains(slaughterhouseName.toLowerCase())) {
                resultList.add(sh);
            }
        }
        return resultList;
    }

    public List<Slaughterhouse> searchByCapacity(int capacity) {
        List<Slaughterhouse> resultList = new ArrayList<>();
        for (Slaughterhouse sh : SlaughterhouseDAO.getInstance().selectAll()) {
            if (sh.getCapacity() >= capacity) {
                resultList.add(sh);
            }
        }
        return resultList;
    }

    public List<Slaughterhouse> searchByContactPerson(String contactPerson) {
        List<Slaughterhouse> resultList = new ArrayList<>();
        for (Slaughterhouse sh : SlaughterhouseDAO.getInstance().selectAll()) {
            if (sh.getContactPerson().toLowerCase().contains(contactPerson.toLowerCase())) {
                resultList.add(sh);
            }
        }
        return resultList;
    }
}
