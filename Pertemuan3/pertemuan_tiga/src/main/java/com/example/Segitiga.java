package com.example;

/**
 * Created by hilmiat on 8/5/17.
 */

public class Segitiga {
    private int alas,tinggi;
    public float hitungLuas(){
        return this.alas * this.tinggi * 0.5f;
    }
    public void perbesar(int kali){
//        this.alas *= kali;
//        this.tinggi *= kali;
        this.alas = this.alas * kali;
        this.tinggi = this.tinggi * kali;
    }
    public void perkecil(int kali){
//        this.alas /= (float)kali;
//        this.tinggi /= (float)kali;
        try {
            this.alas = this.alas / kali;
            this.tinggi = this.tinggi / kali;
        }catch (ArithmeticException e){
            this.alas = 0;
            this.tinggi = 0;
        }
    }

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public Segitiga() {
    }
}
