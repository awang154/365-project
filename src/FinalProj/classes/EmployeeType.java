package FinalProj.classes;

public class EmployeeType {
    private int tID;
    private String tName;

    public EmployeeType(int tID, String tName){
        this.tID = tID;
        this.tName = tName;
    }

    // return statements
    public int gettid(){
        return tID;
    }

    public void setTypeId(int tid){
        this.tID = tid;
    }

    public String get_tName(){
        return tName;
    }

    public void set_tName(String tName){
        this.tName = tName;
    }
}
