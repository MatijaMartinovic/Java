package pckg_fst;

public class Student {

    private static String name;
    private static int yearOfStudy;
    private static String university;
    private static String studyProgram;

    public Student(String name, int yearOfStudy, String university, String studyProgram) {
        this.university = uni;
        this.name=name;
        this.yearOfStudy = year;
        this.studyProgram = studyP;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public static int getYearOfStudy() {
        return yearOfStudy;
    }

    public static void setYearOfStudy(int yearOfStudy) {
        Student.yearOfStudy = yearOfStudy;
    }

    public static String getUniversity() {
        return university;
    }

    public static void setUniversity(String university) {
        Student.university = university;
    }

    public static String getStudyProgram() {
        return studyProgram;
    }

    public static void setStudyProgram(String studyProgram) {
        Student.studyProgram = studyProgram;
    }
}
