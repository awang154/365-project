package main;

public class HoursWorked {
    private int empID;
    private String date;
    private double hrsWorked;

    // hours worked info
    public HoursWorked(int empID, String date, double hrsWorked){
        this.empID = empID;
        this.date = date;
        this.hrsWorked = hrsWorked;
    }

    // return statements
    public int getempID(){
        return empID;
    }

    public void setempID(int empID){
        this.empID = empID;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public double gethrsWorked(){
        return hrsWorked;
    }

    public void setHoursWorked(double hrsWorked){
        this.hrsWorked = hrsWorked;
    }
}

