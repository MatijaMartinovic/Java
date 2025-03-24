package pckg_polymorphism;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Animal();
        animals[1] = new Tiger();
        animals[2] = new Dog();
        animals[3] = new RubberHorse();
        System.out.println(Arrays.toString(animals));
        testAllAnimalSounds(animals);
    }

    private static void testAllAnimalSounds(Animal[] animals){
        for(Animal animal : animals){
            animal.makeSomeSound(100);
        }
    }
}
