package pckg_abs_cls;

public abstract class SpaceShip implements FightMode{

    protected String name;
    protected String firstFlight;

    protected SpaceShip(String name, String firstFlight) {
        this.firstFlight = firstFlight;
        this.name = name;
    }

    protected abstract void performHSpaceJump();

    public void flyFromPlanet(){
        System.out.println(getClass().getSimpleName() + "flying from planet!!!");
    }
}
