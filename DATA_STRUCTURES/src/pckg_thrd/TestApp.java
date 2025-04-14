package pckg_thrd;

import java.util.Stack;

public class TestApp {

    public static void main(String[] args) {
        Stack<Person> stackedPersons = new Stack<>();
        stackedPersons.add(new Person("Mina"));
        stackedPersons.add(new Person("Mia"));
        stackedPersons.add(new Person("Emma"));
        stackedPersons.add(new Person("Cete"));
        System.out.println(stackedPersons);
        Person person = stackedPersons.peek();
        System.out.println(person);
        System.out.println(stackedPersons);
    }
}
