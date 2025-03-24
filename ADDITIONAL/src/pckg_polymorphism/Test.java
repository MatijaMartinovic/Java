package pckg_polymorphism;

public class Test {

    public static void main(String[] args) {
        SmartTv smartTV = new SmartTv();
        TV tv = new TV();
        tv.turnON();
        tv.changeChannel();
    }
}
