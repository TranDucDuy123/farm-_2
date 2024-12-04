package controller;

import dao.FarmDAO;
import model.Farm;
import java.util.ArrayList;

public class SearchFarm {

    public static SearchFarm getInstance() {
        return new SearchFarm();
    }

    // Tìm kiếm tất cả farm dựa trên tên, địa chỉ, hoặc chủ sở hữu
    public ArrayList<Farm> searchTatCa(String text) {
        ArrayList<Farm> result = new ArrayList<>();
        ArrayList<Farm> farms = (ArrayList<Farm>) FarmDAO.getInstance().selectAll();
        for (var farm : farms) {
            if (farm.getFarmName().toLowerCase().contains(text.toLowerCase()) 
                || farm.getAddress().toLowerCase().contains(text.toLowerCase())
                || farm.getOwner().toLowerCase().contains(text.toLowerCase())) {
                result.add(farm);
            }
        }
        return result;
    }

    // Tìm kiếm theo mã farm (farm_id)
    public ArrayList<Farm> searchMaFarm(String text) {
        ArrayList<Farm> result = new ArrayList<>();
        ArrayList<Farm> farms = (ArrayList<Farm>) FarmDAO.getInstance().selectAll();
        for (var farm : farms) {
            if (String.valueOf(farm.getFarmId()).contains(text)) {
                result.add(farm);
            }
        }
        return result;
    }

    // Tìm kiếm theo tên farm
    public ArrayList<Farm> searchTenFarm(String text) {
        ArrayList<Farm> result = new ArrayList<>();
        ArrayList<Farm> farms = (ArrayList<Farm>) FarmDAO.getInstance().selectAll();
        for (var farm : farms) {
            if (farm.getFarmName().toLowerCase().contains(text.toLowerCase())) {
                result.add(farm);
            }
        }
        return result;
    }

    // Tìm kiếm farm theo tên huyện
    public ArrayList<Farm> searchByDistrictName(String districtName) {
        ArrayList<Farm> result = new ArrayList<>();
        ArrayList<Farm> farms = (ArrayList<Farm>) FarmDAO.getInstance().searchByDistrictName(districtName);
        for (var farm : farms) {
            result.add(farm);
        }
        return result;
    }

    // Tìm kiếm farm theo tên xã
    public ArrayList<Farm> searchByCommuneName(String communeName) {
        ArrayList<Farm> result = new ArrayList<>();
        ArrayList<Farm> farms = (ArrayList<Farm>) FarmDAO.getInstance().searchByCommuneName(communeName);
        for (var farm : farms) {
            result.add(farm);
        }
        return result;
    }
}
