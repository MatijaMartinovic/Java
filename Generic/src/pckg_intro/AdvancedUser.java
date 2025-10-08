package pckg_intro;

public class AdvancedUser extends SimpleUser{

    public AdvancedUser(String name){
        super(name);
    }

    @Override
    public void performSomething() {
        super.performSomething();
        System.out.println("This one can do something special!");
    }
}
