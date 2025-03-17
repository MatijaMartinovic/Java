package pckg_abs_cls;

public class App {
    public static void main(String[] args) {
        SpaceShipClassA spaceShipClassA = new SpaceShipClassA("Enterprise", "Today");
        spaceShipClassA.performHSpaceJump();
        spaceShipClassA.flyFromPlanet();
        spaceShipClassA.performAttackWithBlaster();
        spaceShipClassA.performAttackWithPlasmaGun();
    }
}
