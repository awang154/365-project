package main;

public class EmployeeType {
    private int etID;
    private String tName;

    // employee type info
    public EmployeeType(int etID, String tName){
        this.etID = etID;
        this.tName = tName;
    }

    // return statements
    public int getetID(){
        return etID;
    }

    public void setetID(int etID){
        this.etID = etID;
    }

    public String gettName(){
        return tName;
    }

    public void settName(String tName){
        this.tName = tName;
    }
}

