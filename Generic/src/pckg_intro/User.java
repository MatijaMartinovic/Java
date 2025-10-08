package pckg_intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User<E> {

    private int id;
    private String name;
    private final ArrayList<E> list;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.list = new ArrayList<>();
    }

    public User(int id, String name, ArrayList<E> list){
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public void info(Set<String> someSet){
        System.out.println(someSet);
    }

    public void info(List<Integer> set){
        System.out.println(set);
    }

}
