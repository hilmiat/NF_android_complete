package com.example;

/**
 * Created by hilmiat on 8/12/17.
 */

public abstract class Binatang {
    String nama,jenis;
    abstract void bersuara();
}

class Ayam extends Binatang{
    Ayam(){
        super.nama = "Ayam";
        super.jenis = "Unggas";
    }

    @Override
    void bersuara() {
        System.out.println("Kokok petok..");
    }
}