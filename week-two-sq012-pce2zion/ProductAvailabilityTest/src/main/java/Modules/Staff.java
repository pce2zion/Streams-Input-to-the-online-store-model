package Modules;

public class Staff extends Person{

    private  Integer staffId;
    public Staff() {
    }


    public Staff(Integer id, String firstName, String lastName, String email, Integer staffId) {
        super(id, firstName, lastName, email);
        this.staffId = staffId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                "} " + super.toString();
    }

}
