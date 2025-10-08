package pckg_guess_game;

import java.util.ArrayList;
import java.util.Scanner;

public class AgeGuessGame {
    private static Scanner scanner;
    private static ArrayList<Integer> guesses;


    public static void startGame(Player player){
        guesses = new ArrayList<>();
        boolean continuePlay = true;
        scanner = new Scanner(System.in);
        int ageToGuess = AUX_CLS.generateRandomAge();
        while (continuePlay) {
            AUX_CLS.enterGuessInter(scanner);
            logPlayerGuess(AUX_CLS.getEnteredAgeValue());
            if (AUX_CLS.isGuess(ageToGuess)){
                System.out.println("you have guessed the random value: " + ageToGuess);
                continuePlay = false;
            } else {
                System.out.println("Sorry - you have missed secret age value!");
                AUX_CLS.helperGuessAttepmpt(ageToGuess);
                continuePlay = !(continueToPlay());
            }
        }
        System.out.println("GAME OVER!!!");
        provideGameStat();
        player.addGameResults(guesses);
    }



    public static boolean continueToPlay() {
        System.out.println("To continue press 'y' and other for no!");
        String inp = scanner.nextLine();
        return "y".equalsIgnoreCase(inp);
    }

    public static void logPlayerGuess(int playerGuess){
        guesses.add(playerGuess);
    }

    public static void provideGameStat(){
        System.out.println("======================== PLAYER GUESS STAT ======================");
        System.out.println("Total guesses: " + guesses.size());
        System.out.println("All attepmpt: " + guesses);
    }

    public static class AppTest {

        private static Scanner scanner;
        public static void main(String[] args) {
            scanner = new Scanner(System.in);
            Player player = new Player(new Person("Roko"),"PL-23434");
            //AgeGuessGame.startGame(player);
            playNewGame(player);
            player.seeGameResults();
        }

        public static void playNewGame(Player player){
            boolean play = true;
            while(play){
                startGame(player);
                System.out.println("new game for this player - 'y' for yes, any other for no!");
                play = "y".equalsIgnoreCase(scanner.nextLine());
            }
            System.out.println("Out of this Game Block");
        }
    }
}
