package FinalProj.classes;

public class WorkSchedule{
    private int schedID;
    private String date;
    private int empID;

    // work schedule info
    public WorkSchedule(int schedID, String date, int empID){
        this.schedID = schedID;
        this.date = date;
        this.empID = empID;
    }

    // return statements
    public int getschedID(){
        return schedID;
    }

    public void setschedID(int schedID){
        this.schedID = schedID;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getempID(){
        return empID;
    }

    public void setempID(int empID){
        this.empID = empID;
    }
}
