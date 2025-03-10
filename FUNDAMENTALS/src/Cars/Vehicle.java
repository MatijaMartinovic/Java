package Cars;

import java.util.Date;

public class Vehicle {

    private String brand;
    private String model;
    private Date year;
    private static int cntID = 200;
    private int vehID;

    public Vehicle(String brand, String model, Date year){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vehID = cntID++;
    }

    public void start(){

    }

    public void stop(){

    }

    public String info(){
        return "";
    }
}
