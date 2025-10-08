package pckg_snd;

public class AppTest {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.populateDataFromFile("GITVjezba/src/chat/author_title.txt");
        System.out.println("Učitani podaci:");
        manager.printAuthorTitles();
        manager.addNewEntry("Albert Einstein", "The World as I see it");

        System.out.println("\nNakon dodavanja jednog unosa:");
        manager.printAuthorTitles();
        System.out.println("\nAutori čije ime počinje sa 'A':");
        manager.listAllAuthorsThatBeginsWith("A");
        System.out.println("\nNaslovi autora 'Ernest Hemingway':");
        manager.listAllTitlesForAuthor("Ernest Hemingway");
        manager.addNewEntry("Albert Einstein", "Special Theory of Relativity");

        System.out.println("\nNakon dodavanja drugog unosa:");
        manager.printAuthorTitles();
        manager.writeDataIntoFile("DATA/at_2.txt");
    }
}
