package pckg_polymorphism;

public class Tiger extends Animal{

    @Override
    public void makeSomeSound(int soundVolume) {
        System.out.println("Making some specific sound for tiger. It is very loud...");
        System.out.println("Volume is:" + soundVolume);
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
