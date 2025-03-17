package pckg_abs_cls;

public class SpaceShipClassA extends SpaceShip{

    private long numberOfMissions;

    protected SpaceShipClassA(String name, String firstFlight) {
        super(name, firstFlight);
        this.numberOfMissions = 0;
    }

    @Override
    protected void performHSpaceJump() {
        System.out.println("This space ship class can not make HSpace Jump");
    }

    @Override
    public String toString() {
        return "SpaceShipClassA{" +
                "numberOfMissions=" + numberOfMissions +
                ", name='" + name + '\'' +
                ", firstFlight='" + firstFlight + '\'' +
                '}';
    }

    @Override
    public void flyFromPlanet() {
        super.flyFromPlanet();
        numberOfMissions++;
    }

    @Override
    public void performAttackWithBlaster() {
        System.out.println("Furious Attack with Blasters.");
    }

    @Override
    public void performAttackWithPlasmaGun() {
        System.out.println("Plasma attack full strength!");
    }
}
