package Vjezba2;

import Vjezba3.Robot;
import org.w3c.dom.ls.LSOutput;

import static Vjezba3.Robot.*;

public class App {
    public static void main(String[] args) {
        Robot robot = new Robot(15, "Robert");
        System.out.println("Name: " + robot.getName());
        System.out.println("ID: " + robot.getId());
        robot.walk();
        factJel(robot.getId());
        System.out.println("Factoriel of " + robot.getId() + " is " + factJel(robot.getId()));
        for(int k=0;k<20;k++){
            fillArr(k);
        }
        printArr();
        printMatrix();
    }

}
