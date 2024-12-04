package model;

public class Farm {
    private int farmId;
    private String farmName;
    private String address;
    private int districtId;
    private int communeId;
    private String owner;

    // Constructor
    public Farm(int farmId, String farmName, String address, int districtId, int communeId, String owner) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.address = address;
        this.districtId = districtId;
        this.communeId = communeId;
        this.owner = owner;
    }
    public Farm( String farmName, String address, int districtId, int communeId, String owner) {
        this.farmName = farmName;
        this.address = address;
        this.districtId = districtId;
        this.communeId = communeId;
        this.owner = owner;
    }
    public Farm(){}

    // Getter and Setter methods
    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getCommuneId() {
        return communeId;
    }

    public void setCommuneId(int communeId) {
        this.communeId = communeId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Farm [farmId=" + farmId + ", farmName=" + farmName + ", address=" + address + ", districtId=" + districtId 
                + ", communeId=" + communeId + ", owner=" + owner + "]";
    }
}
