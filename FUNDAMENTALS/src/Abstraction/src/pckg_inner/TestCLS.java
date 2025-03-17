package pckg_inner;

public class TestCLS {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle() {
            @Override
            public void startEngine() {
                System.out.println("Starting an engine!");
            }

            @Override
            public void stopEngine() {
                System.out.println("Engine is stopped!");
            }
        };

    }
}
