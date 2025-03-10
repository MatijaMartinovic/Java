package pckg_uml;

public class Car {

    private String brand;
    private String model;
    private Mechanic mechanic;

    public Car(String brand, String model){
        this.brand = brand;
        this.model = model;

    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mechanic=" + mechanic +
                '}';
    }

    public void serviceCar(){
        System.out.println(mechanic+" performing service on the: " + this.getClass().getSimpleName());
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
