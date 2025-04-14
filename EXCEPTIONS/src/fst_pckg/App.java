package fst_pckg;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class App {

    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        double db;
        System.out.println("Enter one double value...");
        db = scanner.nextDouble();
        System.out.println(db);
        String filePath = "src/my_file.txt";
        readFile(filePath);
    }

    private static void readFile(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        try {
            scanner = new Scanner(path);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
