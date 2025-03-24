package pckg_polymorphism;

public class AIEntity {

    private String modelName;

    public AIEntity(String model){
        this.modelName = model;
    }

    public void doSomethingIntelligent(int n1, int n2){
        System.out.println("Performing intelligent stuff...");
        System.out.println(n1+n2);
    }

    public void doSomethingIntelligent(int n1, int n2, String msg){
        System.out.println("In another way intelligent behaviour...");
        System.out.println(n1*n2);
        System.out.println("I can talk also..." + msg);
    }
}
