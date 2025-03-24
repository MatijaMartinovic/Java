package pckg_polymorphism;

public class TV extends Device{

    public TV(){
        super("DV200");
        System.out.println("This is from TV constructor: " + this.getClass().getSimpleName());
        System.out.println(this);
    }

    @Override
    public void turnON() {
        System.out.println("Turning on TV with remote controller!");
    }

    public void changeChannel(){
        System.out.println("Changing channel using remote controller...");
    }
}
