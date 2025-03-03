package pckg_fst;

public class AppTest {

    public static void main(String[] args) {
        Student s1=new Student(name:"Marina", uni:"UNIZD",studyP:"Computer Science", year:3);
        Student s2=new Student(name:"Marko", uni:"UNIZD",studyP:"IT", year:4)
        System.out.println(s1);
        System.out.println(s2);
        s2.setName("Markisa");
        System.out.println(s2.getName());
    }
}
