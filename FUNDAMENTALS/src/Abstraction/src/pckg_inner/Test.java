package pckg_inner;

public class Test {

    public static void main(String[] args) {
        Outer outer = new Outer("Msg for outer...");
        outer.seeMessage();
        Outer.Inner inner = new Outer.Inner("Another msg for inner");
        inner.showMsg();
        inner.showOuterMsg();
    }
}
