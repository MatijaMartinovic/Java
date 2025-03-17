package pckg_abs_cls;

public class Camera extends Device{

    private final String focus;

    public Camera(String brand, String model){
        this.focus = "Automatic";
        this.model = model;
        this.brand = brand;
    }

    public Camera(String brand, String model, String focus){
        this.brand = brand;
        this.model = model;
        this.focus = focus;
    }



    @Override
    protected void recordingPicture() {
        System.out.println("Recording pictures with camera...");
    }

    @Override
    protected void recordingVidoes() {
        System.out.println("Recording vidoes with camera...");
    }


}
