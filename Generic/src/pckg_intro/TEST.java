package pckg_intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TEST {
// parametriziranje
    public static void main(String[] args) {
        ArrayList<Integer> ilist = new ArrayList();
        ArrayList<Float> flist = new ArrayList();
        ArrayList<String> slist = new ArrayList();
        User<Integer> user = new User<>(10, "Ivana");
        user.info(ilist);
    }

    private static void printIListElements(ArrayList lista){
        Iterator iter = lista.iterator();
        while(iter.hasNext()){
            Integer element = (Integer) iter.next();
            System.out.println(element);
        }
    }

    private static void printFListElements(ArrayList lista){
        Iterator iter = lista.iterator();
        while(iter.hasNext()){
            Float element = (Float) iter.next();
            System.out.println(element);
        }
    }

    private static void printSListElements(ArrayList lista){
        Iterator iter = lista.iterator();
        while(iter.hasNext()){
            String element = (String) iter.next();
            System.out.println(element);
        }
    }

    private static <E> void printAnyListElements(ArrayList<E> list){
        for(E element : list){
            System.out.println(element);
        }
    }


    private static <K, V> void ListMapElements(Map<K, V> map){
        for(K key : map.keySet()){
            System.out.println("Key: " + key);
            System.out.println("Value: " + map.get(key) + "\n");
        }
    }


}