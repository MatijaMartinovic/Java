package pckg_bidirectional;

public class CarFactory {

    private String carFactoryBrand;
    private Car car;

    public CarFactory(String brand){
        this.carFactoryBrand = brand;
    }
    public Car produceCar(String model){
        this.car = new Car(model, this.carFactoryBrand, this);
        return this.car;
    }

}
