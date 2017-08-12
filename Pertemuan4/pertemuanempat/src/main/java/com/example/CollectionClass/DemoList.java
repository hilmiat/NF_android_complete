package com.example.CollectionClass;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hilmiat on 8/12/17.
 */

public class DemoList {
    public static void main(String[] args) {
        String[] nama_siswa = new String[59];

        List l = new ArrayList<String>();
        //untuk memasukkan data ke list
        l.add("Joni");
        l.add("Adi");
        l.add("Edo");
        l.add("Amir");
        //untuk insert data
        l.add(3,"Jono");
        //mengetahui ukuran list
        System.out.println("ukuran list"+l.size());
        //get all data
        for(Object isi : l){
            System.out.println(l);
        }
        //membaca 1 elemen data
        System.out.println("elemen ke-2:"+l.get(2));
        //remove element berdasarkan index
        l.remove(2);
        System.out.println("Setelah elemen ke-2 dihapus:");
        //cetak elemen
        System.out.println(l);
        //remove berdasarkan isi
        l.remove("Joni");
        System.out.println("serelah joni diremove");
        System.out.println(l);
        //cek list apakah mengandung isi tertentu
        System.out.print("Apakah mengandung Amir?");
        if(l.contains("Amir")){
            System.out.println("Iya");
        }else{
            System.out.println("Tidak");
        }
        //konversi dari array ke list
        String[] list2 = {"Eka","Eko","Oka"};
        List l2= Arrays.asList(list2);
        System.out.println("isi l2:"+l2);
        //menggabungkan list
        l.addAll(l2);
        System.out.println("isi setelah digabungkan:"+l);
        //Sorting
        Collections.sort(l);
        System.out.println("setelah di sort"+l);
        //hapus sebagian data
        l.removeAll(l2);
        System.out.println("Setelah dikurang l2"+l);


    }
}
