package pckg_bidirectional;

public class CarFactoryTest {


    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory("Mercedes");
        Car car = carFactory.produceCar("SLK");
        System.out.println(car);
    }
}
