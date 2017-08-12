package com.example;

/**
 * Created by hilmiat on 8/12/17.
 */

public class DemoBinatang {
    public static void main(String[] args) {
        Binatang b = new Binatang() {
            @Override
            void bersuara() {
                System.out.println("Mbeeek....");
            }
        };

        b.bersuara();

        //polymorphisme
        Binatang a = new Ayam();
        Ayam a2 = new Ayam();
//    Ayam a3 = new Binatang();

        a2.bersuara();
    }
}
