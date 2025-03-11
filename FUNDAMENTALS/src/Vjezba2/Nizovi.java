package Vjezba2;

import org.w3c.dom.ls.LSInput;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Nizovi {

    public static void main(String[] args) {
        String[] strings = {"Vasa", "vana plurimum", "sonant"};
        String[] strings2 = new String[4];

        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<4; i++){
            System.out.println("Unos " + (i+1) + ": ");
            strings2[i] = scanner.nextLine();
        }
        scanner.close();
        System.out.println("Spajanje prvog niza...");
        System.out.println(strings[0] + " " + strings[1] + " " + strings[2]);

        System.out.println("Ispis elemenata drugog niza jedan ispod drugog...");

        for (String element : strings2){
            System.out.println(element);
        }
    }

}
