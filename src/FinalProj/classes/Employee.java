package FinalProj.classes;

public class Employee{
    public enum level {
        management,
        employee
    }

    private int empID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int empType;

    // employee info
    public Employee(int empID, String firstName, String lastName, String phoneNumber, int empType){
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.empType = empType;
    }

    // return statements
    public int getEmployeeId(){
        return empID;
    }

    public void setEmployeeId(int empID){
        this.empID = empID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getEmpType(){
        return empType;
    }

    public void setEmpType(int empType){
        this.empType = empType;
    }
}
