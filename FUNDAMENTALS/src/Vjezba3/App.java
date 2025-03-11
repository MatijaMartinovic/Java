package Vjezba3;

public class App {
    public static void main(String[] args) {
        int x = 10;
        double h = 179;
        Person prs = new Person();

        System.out.println("Values before function call: " + x + " and: " + h);
        changes(x, h);
        System.out.println("Values after function call: " + x + " and: " + h);
        System.out.println("Now for objects...");
        System.out.println("Person name before fnct call: " + prs.getName());
        System.out.println("Person height before fnct call: " + prs.getHeight());

        changePers(prs);

        System.out.println("Person name after fnct call: " + prs.getName());
        System.out.println("Person height after fnct call: " + prs.getHeight());

    }

    private static void changes(int x, double h) {

        x = x + 10;
        h = 100 + h;
        System.out.println("Values in function changes: " + x + " and: " + h);
    }

    private static void changePers(Person prs) {

        prs.setName("new name");
        prs.setHeight(200);

        System.out.println("From function: ");
        System.out.println(prs.getName());
        System.out.println(prs.getHeight());
    }
}

