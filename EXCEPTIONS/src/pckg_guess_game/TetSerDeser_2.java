package pckg_guess_game;

import java.util.ArrayList;

public class TetSerDeser_2 {

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Player[] playersArray = {new Player(new Person("Miku"), "Mii342"), new Player(new Person("Mina"), "Mini162")};
        populatePlayers(players, 5);
        listAllPlayers(players);
        String pathToSavePlayers = "players_arr_list.bin";
        AUX_CLS.savePlayersListToFile(players, pathToSavePlayers);
        ArrayList<Player> playersNew = AUX_CLS.readPlayersFromFile(pathToSavePlayers);
        listAllPlayers(players);
        AUX_CLS.savePlayersArrInFile(playersArray, "data_Arr_File.bin");
    }

    private static void populatePlayers(ArrayList<Player> players, int numPlayers) {
        for(int k = 0; k<numPlayers; k++) {
            Player player = new Player(new Person("Player-" + k), "GamePlayerName_" + k);
            players.add(player);
        }
        System.out.println("All players added to a list!");
    }

    private static void listAllPlayers(ArrayList<Player> players) {
        System.out.println("\n--------------------------------------------------------");
        for(Player player : players) {
            System.out.println(player);
        }
    }
}
