package pckg_bidirectional;

public class Car {

    private String model;
    private String brand;
    private CarFactory carFactory;

//    public Car(String model, String brand, carFactory carFactoryBrand){
//        this.brand = brand;
//        this.carFactory = carFactory;
//        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carFactory=" + carFactory +
                '}';
    }
}
