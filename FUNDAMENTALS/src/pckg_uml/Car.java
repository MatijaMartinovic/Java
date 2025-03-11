package pckg_uml;

public class Car {

    private String brand;
    private String model;
    private Mechanic mechanic;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;

    }


    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
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
        System.out.println(mechanic + " perforiming service on the: " + this.getClass().getSimpleName());
    }
}