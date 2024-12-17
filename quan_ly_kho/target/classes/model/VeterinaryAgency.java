package model;

public class VeterinaryAgency {
    private int agencyId;
    private String agencyName;
    private String address;
    private String contactPerson;
    private String contactPhone;

    // Constructors
    public VeterinaryAgency(int agencyId, String agencyName, String address, String contactPerson, String contactPhone) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public VeterinaryAgency(String agencyName, String address, String contactPerson, String contactPhone) {
        this.agencyName = agencyName;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public VeterinaryAgency() {}

    // Getter and Setter
    public int getAgencyId() { return agencyId; }
    public void setAgencyId(int agencyId) { this.agencyId = agencyId; }

    public String getAgencyName() { return agencyName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    @Override
    public String toString() {
        return "VeterinaryAgency [agencyId=" + agencyId + ", agencyName=" + agencyName +
               ", address=" + address + ", contactPerson=" + contactPerson + ", contactPhone=" + contactPhone + "]";
    }
}
