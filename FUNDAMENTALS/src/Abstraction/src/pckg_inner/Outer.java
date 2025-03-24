package pckg_inner;

public class Outer {

    private static String someMsg;

    public Outer(String msg){
        this.someMsg = msg;
    }

    public void seeMessage(){
        System.out.println("Msg from Outer class: " + someMsg);
    }
    static class Inner{
        String innerMsg;

        public Inner(String msg){
            this.innerMsg = msg;
        }

        public void showMsg(){
            System.out.println("From inner cls msg is: " + innerMsg);
        }

        public void showOuterMsg(){
            System.out.println("From inner we have got access to this: " + someMsg);
        }
    }
}
