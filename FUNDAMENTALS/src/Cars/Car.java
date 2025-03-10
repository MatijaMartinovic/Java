package Cars;

public class Car {

    private String model;
    private String brand;
    private String yOfProduction;
    private String color;
    private boolean failedToStart;


    public Car(String model, String brand){
        this.model=model;
        this.brand=brand;
        this.failedToStart = false;
        System.out.println("The base constructor...");
    }

    public Car(String model, String brand, String yOfProduction, String color){
        this(model, brand);
        System.out.println("Additional fields in construction...");
        this.color = color;
        this.yOfProduction = yOfProduction;
    }
    public void setFailedToStart(){
        this.failedToStart = true;
        System.out.println("Something went wrong with the car...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", failedToStart=" + failedToStart +
                '}';
    }

    public void carObjectInfo(){
        System.out.println(this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()));
    }

    public Car repairCar(ServiceMan serviceMan){
        System.out.println(serviceMan.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()));
        if(failedToStart){
            System.out.println("Repairing a car...");
            this.failedToStart = false;
        }else{
            System.out.println("Already good car...");
        }
        return this;
    }
}
