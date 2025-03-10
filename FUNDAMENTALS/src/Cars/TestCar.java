package Cars;

public class TestCar {

    public static void main(String[] args){
        Car car = new Car( "M5", "BMW");
        car.carObjectInfo();
        System.out.println(car);
        car.setFailedToStart();
        car.carObjectInfo();
        System.out.println(car);
        car.repairCar(new ServiceMan(100));
        car.carObjectInfo();
        System.out.println(car);

        Car sndCar = new Car("Y3", "Toyota", "2020", "Blue"){

        };
    }
}
