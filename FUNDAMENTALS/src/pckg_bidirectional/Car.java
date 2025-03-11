package pckg_bidirectional;

public class Car {

    private String model;
    private String brand;
    private CarFactory carFactoryBrand;

    public Car(String model, String brand, CarFactory carFactoryBrand){
        this.brand = brand;
        this.carFactoryBrand = carFactoryBrand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carFactory=" + carFactoryBrand +
                '}';
    }
}
