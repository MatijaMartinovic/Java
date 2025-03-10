package Cars;

public class Student {

    private String name;
    private String university;
    private static int cntID  = 100;
    private int id;
    private int yOfStudy;


    public Student(String name, String university){
        this.name = name;
        this.university = university;
        this.id = cntID++; //yofstudy moze i ovdje
    }

    public Student(String name, String uni, int yOfS){
        this(name, uni);
        this.yOfStudy = yOfS;
    }
    public Student nextYearOfStudy(){
        System.out.println("Success - enrolled in next study year!");
        this.yOfStudy++;
        return this;
    }
}
