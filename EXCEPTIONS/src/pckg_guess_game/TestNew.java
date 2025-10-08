package pckg_guess_game;

public class TestNew {
    public static void main(String[] args) {
        Player player1 = new Player(new Person("Miku"), "AFG-334");
        Player player2= new Player(new Person("Iva"), "RESTAPI34");
        String filePath = "players.txt";
        AUX_CLS.savePlayerToTxtFile(player1, filePath);
        AUX_CLS.savePlayerToTxtFile(player2, filePath);
    }
}
