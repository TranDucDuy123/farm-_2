package controller;

import dao.SlaughterhouseDAO;
import model.Slaughterhouse;

import java.util.List;

public class SearchSlaughterhouse {

    // SEARCH BY NAME
    public List<Slaughterhouse> searchByName(String name) {
        String condition = "LOWER(name) LIKE ?";
        return SlaughterhouseDAO.getInstance().queryWithConditions(condition, "%" + name.toLowerCase() + "%");
    }

    // SEARCH BY CAPACITY
    public List<Slaughterhouse> searchByCapacity(int capacity) {
        String condition = "capacity >= ?";
        return SlaughterhouseDAO.getInstance().queryWithConditions(condition, capacity);
    }

    // SEARCH BY CONTACT PERSON
    public List<Slaughterhouse> searchByContactPerson(String contactPerson) {
        String condition = "LOWER(contact_person) LIKE ?";
        return SlaughterhouseDAO.getInstance().queryWithConditions(condition, "%" + contactPerson.toLowerCase() + "%");
    }

    // ADVANCED SEARCH
    public List<Slaughterhouse> advancedSearch(String name, String type, String status, Integer capacity) {
        StringBuilder condition = new StringBuilder();
        if (name != null && !name.isEmpty()) {
            condition.append("LOWER(name) LIKE ? ");
        }
        if (type != null && !type.isEmpty()) {
            if (condition.length() > 0) condition.append("AND ");
            condition.append("type = ? ");
        }
        if (status != null && !status.isEmpty()) {
            if (condition.length() > 0) condition.append("AND ");
            condition.append("status = ? ");
        }
        if (capacity != null) {
            if (condition.length() > 0) condition.append("AND ");
            condition.append("capacity >= ? ");
        }

        return SlaughterhouseDAO.getInstance().queryWithConditions(
            condition.toString(),
            name != null ? "%" + name.toLowerCase() + "%" : null,
            type,
            status,
            capacity
        );
    }
}
