package controller;

import dao.VeterinaryAgencyDAO;
import model.VeterinaryAgency;

import java.util.ArrayList;
import java.util.List;

public class SearchVeterinaryAgency {

    public List<VeterinaryAgency> searchByAgencyName(String agencyName) {
        List<VeterinaryAgency> resultList = new ArrayList<>();
        for (VeterinaryAgency agency : VeterinaryAgencyDAO.getInstance().selectAll()) {
            if (agency.getAgencyName().toLowerCase().contains(agencyName.toLowerCase())) {
                resultList.add(agency);
            }
        }
        return resultList;
    }

    public List<VeterinaryAgency> searchByAddress(String address) {
        List<VeterinaryAgency> resultList = new ArrayList<>();
        for (VeterinaryAgency agency : VeterinaryAgencyDAO.getInstance().selectAll()) {
            if (agency.getAddress().toLowerCase().contains(address.toLowerCase())) {
                resultList.add(agency);
            }
        }
        return resultList;
    }

    public List<VeterinaryAgency> searchByContactPerson(String contactPerson) {
        List<VeterinaryAgency> resultList = new ArrayList<>();
        for (VeterinaryAgency agency : VeterinaryAgencyDAO.getInstance().selectAll()) {
            if (agency.getContactPerson().toLowerCase().contains(contactPerson.toLowerCase())) {
                resultList.add(agency);
            }
        }
        return resultList;
    }
}
