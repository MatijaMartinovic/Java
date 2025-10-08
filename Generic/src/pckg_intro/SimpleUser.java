package pckg_intro;

public class SimpleUser {

    private int id;
    private static int cntID = 100;
    private String name;
    private int hashCode;

    public SimpleUser(String name){
        this.name = name;
        this.id = cntID++;
    }

    public void performSomething(){
        System.out.println(Integer.toHexString(this.hashCode) + "Performing something");
    }
}
