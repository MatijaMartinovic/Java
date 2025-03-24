package pckg_project_1;

public abstract class MediaDevice implements Playable {

    protected String brand;
    protected String model;

    protected MediaDevice(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public abstract void turnONDevice();

    public void initializeBaseMediaDevice(){
        System.out.println("Initializing base media device...");
    }
}
