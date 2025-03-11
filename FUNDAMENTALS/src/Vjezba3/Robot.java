package Vjezba3;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Robot {

    static int[][] arr = new int[5][4];

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

    public static void fillArr(int value){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = value;
                    return;
                }
            }
        }
    }

    public static void printArr(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(){
        for(int[] row : arr){
            System.out.println(Arrays.toString(row));
        }
    }

    public static long factJel(int n) {
        long factoriel = 1;
        for(int i = 1; i<=n; i++){
            factoriel *= i;
        }
        return factoriel;
    }
}
