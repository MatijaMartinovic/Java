package pckg_abs_cls;

public class Test {
    public static void main(String[] args) {
        MobilePhone mp = new MobilePhone("Apple", "16");
        Device camera = new Camera("Canon", "RS100");
        Device[] devices = {mp, camera};
        testDevices(devices);
        mp.saveToCloud();
        mp.surfTheNet();
        mp.performChartGPTResearch();
    }

    private static void testDevices(Device[] devices){

        for(Device device : devices){
            device.chargeDevice();
            device.recordingPicture();
            device.recordingPicture();
        }
    }
}
