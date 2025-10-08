package pckg_fst;

public class AppTest {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        String filePath = "GITVjezba/src/pckg_fst/author_title.txt";
        manager.populatedDataFromFile(filePath);
        manager.printAuthorTitles();
        manager.addNewEntry("Albert Einstein", "The world as I see it");
        manager.printAuthorTitles();
        manager.listAllAuthorsThatBeginsWith("A");
        manager.printAuthorTitles();
        manager.listAllTitlesForAuthor("Albert Einstein");
        manager.addNewEntry("Albert Einstein", "Special Theory of Relativity");
        manager.printAuthorTitles();
        manager.writeDataIntoFile("GITVjezba/src/pckg_fst/at_2.txt");
        manager.listAllTitlesForAuthor("George Orwell");
    }
}
