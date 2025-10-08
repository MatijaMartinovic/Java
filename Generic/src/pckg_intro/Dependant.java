package pckg_intro;
// klasa koja prima sve objektne nasljedene klase
public class Dependant <T extends SimpleUser>{
    private T dependant;
    public Dependant(T dependant) {
        this.dependant = dependant;
    }

    public void someAction(){
        dependant.performSomething();
    }
}
