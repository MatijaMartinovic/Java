package Vjezba3;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Robot {

    private int id;
    private String name;
    //static Scanner scanner = new Scanner(System.in);


    public void walk(){
        System.out.println("I roboti znaju hodati.");
    }

    public Robot(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static long factJel(int n) {
        long factoriel = 1;
        for(int i = 1; i<=n; i++){
            factoriel *= i;
        }
        return factoriel;
    }
}
