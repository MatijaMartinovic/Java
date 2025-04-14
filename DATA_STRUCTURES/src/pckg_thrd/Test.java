package pckg_thrd;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        Person person = new Person("Edi");
        persons.add(person);
        persons.add(person);
        persons.add(new Person("Goga"));
        persons.add(new Person("Misela"));
        persons.add(new Person("Mina"));
        persons.add(new Person("Edi"));
        persons.add(2, new Person("Novi"));
        System.out.println(persons);
        TreeSet<Person> tpersons = new TreeSet<>(persons);
        System.out.println(tpersons);
        LinkedHashSet<Person> lpersons = new LinkedHashSet<>(persons);
        System.out.println(lpersons);
        HashSet<Person> setPersons = new HashSet<>(persons);
        System.out.println(setPersons);
        reverseString("This is a string to reverse");
    }

    private static void reverseString(String someString){
        Stack<Character> chars = new Stack<>();
        for(int idxCh = 0; idxCh < someString.length(); idxCh++){
            //System.out.println(someString.charAt(idxCh));
            chars.add(someString.charAt(idxCh));
        }
        System.out.println(chars);
        String reversed = "";
        while(!chars.isEmpty()){
            Character ch = chars.pop();
            reversed += ch;
        }
        System.out.println(reversed);
    }
}
