package pckg_polymorphism;

public class Dog extends Animal {

    @Override
    public void makeSomeSound(int soundVolume) {
        System.out.println("Av A Av - grrrr");
        System.out.println(soundVolume);
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
