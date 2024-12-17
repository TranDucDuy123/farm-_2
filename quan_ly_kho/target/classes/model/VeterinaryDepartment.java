package model;

public class VeterinaryDepartment {
    private int departmentId;
    private String departmentName;
    private String address;
    private String contactPerson;
    private String contactPhone;

    // Constructors
    public VeterinaryDepartment(int departmentId, String departmentName, String address, String contactPerson, String contactPhone) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public VeterinaryDepartment(String departmentName, String address, String contactPerson, String contactPhone) {
        this.departmentName = departmentName;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    public VeterinaryDepartment() {}

    // Getter and Setter
    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    @Override
    public String toString() {
        return "VeterinaryDepartment [departmentId=" + departmentId + ", departmentName=" + departmentName +
               ", address=" + address + ", contactPerson=" + contactPerson + ", contactPhone=" + contactPhone + "]";
    }
}
