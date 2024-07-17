package FinalProj.classes;

// employee class
public class Employee {
    private int empID;
    private String firstName;
    private String lastName;
    private int empType;

    public Employee(int empID, String firstName, String lastName, int empType){
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public int getempType(){
        return empType;
    }

    public void setempType(int empType){
        this.empType = empType;
    }
}
