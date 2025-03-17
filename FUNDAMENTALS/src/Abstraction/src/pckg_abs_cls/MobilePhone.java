package pckg_abs_cls;

public class MobilePhone extends Device implements InternetFunctionality{

    public MobilePhone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }


    @Override
    protected void recordingPicture() {
        System.out.println("Mobile phone can record pictures...");
    }

    @Override
    protected void recordingVidoes() {
        System.out.println("Mobile Phone can record vidoes...");
    }


    @Override
    public void saveToCloud() {
        System.out.println("Saving to cloud - " + getClass().getSimpleName());
    }

    @Override
    public void surfTheNet() {
        System.out.println("Finding something on Internet - " + getClass().getSimpleName());
    }

    @Override
    public void performChartGPTResearch() {
        System.out.println(getClass().getSimpleName() + "have app for chatGPT...");
    }
}
