package pckg_polymorphism;

public class SmartTv extends TV {

    public SmartTv(){
        System.out.println("This is from SmartTV constructor: " + this.getClass().getSimpleName());
        System.out.println(this);
    }
}
