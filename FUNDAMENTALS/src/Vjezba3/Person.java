package Vjezba3;

public class Person {
    private String name = "ime";
    private double height = 180;
    private double weight = 80;

    public void info(){

        System.out.println("Ime: " + name + ", visina: " + height + ", težina: " + weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
