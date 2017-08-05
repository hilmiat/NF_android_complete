package com.example;

/**
 * Created by hilmiat on 8/5/17.
 */

public class DemoSegitiga {
    public static void main(String[] args) {
        Segitiga s1 = new Segitiga(2,5);
        System.out.println("Luas "+s1.hitungLuas());
        s1.perbesar(2);
        System.out.println("Luas setelah diperbesar "
                +s1.hitungLuas());
        s1.perkecil(2);
        System.out.println("Luas setelah diperkecil "
                +s1.hitungLuas());
        s1.perkecil(0);
        System.out.println("Luas setelah diperkecil "
                +s1.hitungLuas());
    }
}
