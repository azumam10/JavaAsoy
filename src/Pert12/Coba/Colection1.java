package Pert12.Coba;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Colection1 {
    public static void main(String[] args) {
        Collection<String> collection = new  ArrayList<>();

        collection.add("umam");
        collection.add("goro");
        collection.add("fauzi");
        collection.addAll(List.of("virga","rivai"));

        for (String data : collection) {
         System.out.println(data);   
        }

        ArrayList<String> buah = new ArrayList<>();
        buah.add("apel");
        buah.add("mangga");
        buah.add("pisang");

        buah.set(0, "pepaya");
        // System.out.println(buah.get(2));
        buah.remove(2);
        // Collections.sort(buah);
        System.out.println(buah);
        for (Object uhuy : buah) {
            System.out.println(buah);
            
        }

    }
}
