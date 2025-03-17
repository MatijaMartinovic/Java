package pckg_abs_cls;

public abstract class Device {

    protected String brand;
    protected String model;



    public void chargeDevice(){
        System.out.println("Charging device - " + getClass().getSimpleName());
    }

    protected abstract void recordingPicture();
    protected abstract void recordingVidoes();


}
