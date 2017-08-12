package com.example.CollectionClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hilmiat on 8/12/17.
 */

public class DemoMap {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        //menyimpan data ke map
        m.put("007","James");
        m.put("008","Bono");
        System.out.println(m);
        //mengetahui size dari map
        System.out.println("Map m berisi "+m.size()+" elemen");
        //menyimpan data dengan key yang sama (replace)
        m.put("008","Bond");
        System.out.println(m);
        //remove elemen
        m.remove("008");
        System.out.println("setelah diremove:"+m);
        m.put("009","Udin");
        m.put("010","Carla");
        //mencari berdasarkan key
        if(m.containsKey("007")){
            System.out.println("Ada elemen dengan key 007");
        }else{
            System.out.println("tidak ada elemen dengan key 007");
        }
        //mencari berdasarkan value
        if(m.containsValue("James")){
            System.out.println("terdapat james dalam data");
        }else{
            System.out.println("james tidak ada...");
        }
    }
}
