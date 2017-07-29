package com.example;


import java.util.Arrays;

/**
 * Created by hilmiat on 7/29/17.
 */

public class OperasiArray {
    /**
     * Fungsi cetak string
     * @param text
     */
    public static void cetak(String text){
        System.out.println(text);
    }
    //overloading method
    public static void cetak(int angka){
        System.out.println(angka);
    }
    /**
     * Fungsi cetak array of integer
     * @param arr
     */
    public static void cetakArray(int[] arr){
        for(int nil:arr){
            cetak(nil);
        }
    }
    /**
     * Fungsi hitung total array int
     * @param arr
     * @return int total
     */
    public static int hitungTotal(int[] arr){
        //menghitung total nilai
        int total = 0;
        for(int nil:arr){
            total = total + nil;
        }
        return total;
    }

    public static int getMax(int[] arr){
        int tertinggi=arr[0];
        for(int nil:arr){
            if(tertinggi < nil){
                tertinggi = nil;
            }
        }
        return tertinggi;
    }
    public static void main(String[] args) {
        int[] nilai = {80,90,75,65};
        cetak("nilai:"+nilai);
        cetakArray(nilai);
        int total = hitungTotal(nilai);
        cetak("Total nilai:"+total);
        //hitung nilai rata-rata
        cetak("Rerata: "+((float)total / nilai.length));

        //mencari nilai tertinggi
        int tertinggi = getMax(nilai);

        cetak("Nilai tertinggi:"+tertinggi);
        //mencari nilai terkecil
        int terkecil = nilai[0];
        for(int n:nilai){
            if(terkecil > n){
                terkecil = n;
            }
        }
        cetak("Nilai terkecil:"+terkecil);
        //urutkan array
        Arrays.sort(nilai);
        cetakArray(nilai);
    }
}
