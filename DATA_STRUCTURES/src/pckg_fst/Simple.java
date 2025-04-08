package pckg_fst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Simple {

    private static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1000);
        numbers.add(1000);
        numbers.add(1000);
        ArrayList<String> strings = new ArrayList<>();
        listElementsFromList(numbers);
        System.out.println(numbers);
        generateNewElements(numbers);
        System.out.println(numbers);
        listElements(numbers);
        addElementsToList(strings, numbers);
        System.out.println(strings);
        listElementsFromList(strings);
        System.out.println(numbers);
        HashSet<Integer> unique = returnUnicorns(numbers);
        System.out.println(unique);
    }

    private static void listElements(ArrayList<Integer> lista) {
        for(Integer num:lista){
            System.out.println(num);
        }
    }

    private static <E> HashSet<E> returnUnicorns(ArrayList<E> lst){
        HashSet<E> unique = new HashSet<>(lst);
        return unique;
    }

    private static <E> ArrayList returnUnicornsSnd(ArrayList<E> lst){
        ArrayList<E> uni = new ArrayList<>();
        for(E element:lst){
            if(uni.contains(element)){
                System.out.println("Already in the list!");
            }else{
                uni.add(element);
            }
        }
        return uni;
    }

    private static void listSElements(ArrayList<String> lst){
        for(String el:lst){
            System.out.println(el);
        }
    }

    private static <E> void listElementsFromList(ArrayList<E> lst){
     for(E element:lst){
         System.out.println(element);
     }
    }

    private static void addElementsToList(ArrayList<String> lst, ArrayList<Integer> nums){
        for(Integer num:nums){
            lst.add(String.valueOf(num));
        }
    }

    //Dodavamo random brojeve na prvih 10 mjesta
//    public void addToArray(ArrayList<Integer> arr){
//        for(int k=1;k<=10;k++){
//            ArrayList<E> arr[k] == Math.random();
//        }
//    }

    private static void generate10Elements(ArrayList<Integer> numbs){
        for(int k = 0; k < 10; k++){
//            numbs.add((int) Math.random()*100);
            numbs.add(ThreadLocalRandom.current().nextInt(-100,100));
        }
    }

    private static void generateNewElements(ArrayList<Integer> nums){
        for(int k = 0; k < 10; k++){
//            numbs.add((int) Math.random()*100);
            nums.add(random.nextInt(-20,300));
        }
    }
}
