package pckg_polymorphism;

public class RubberHorse extends Animal{

    @Override
    public void makeSomeSound(int soundVolume) {
        System.out.println("Rubber toy animals can not produce sounds.");
        System.out.println("Sound volume is not useful...");
    }

    @Override
    public String toString() {
        return "RubberHorse";
    }
}
