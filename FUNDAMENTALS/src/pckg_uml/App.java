package pckg_uml;

public class App {
    public static void main(String[] args) {
//        Boat b1 = new Boat();
//        b1.start();
//        b1.stop();
//        b1.run();
//        Yacht y1 = new Yacht();
//        y1.start();
//        y1.stop();
//        y1.run();
//        y1.goToTurboMode();

        Vehicle[] boats = createBoats(10);
        System.out.println(boats[9]);
        boats[9] = new Yacht();
        System.out.println(boats[9]);
        testClassElements(boats);

    }

    static Boat[] createBoats(int numberOfBoats) {
        Boat[] boats = new Boat[numberOfBoats];
        for(int k = 0; k < boats.length; k++) {
            boats[k] = new Boat();

        }
        System.out.println(("Boats are created " + boats.length));
        return boats;
    }
    static void testClassElements(Vehicle[] boats) {
        for (Vehicle boat : boats) {
            boat.run();
        }
    }
}