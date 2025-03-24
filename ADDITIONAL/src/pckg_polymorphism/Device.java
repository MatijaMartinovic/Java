package pckg_polymorphism;

public class Device {
    private String name;
    public Device(String name){
        System.out.println("This is from device: " + this.getClass().getSimpleName());
        System.out.println(this);
        this.name = name;
    }

    public void turnON(){
        System.out.println("Turning on device...");
    }
}
