package com.example;

import java.util.Scanner;

/**
 * Created by hilmiat on 8/5/17.
 */

public class DemoException {
//    public static void cetakElemenArray(String[] ar,int idx){
//        try {
//            System.out.println("Elemen idx ke-3:" + ar[idx]);
//        }catch (Exception e){
//            System.out.println("Index elemen lebih besar dari yang seharusnya");
//        }
//    }

    public static void cetakElemenArray(String[] ar,int idx)throws Exception{
            System.out.println("Elemen idx ke-3:" + ar[idx]);
    }
    public static void main(String[] args) {
        String[] namaSiswa = {"Adi","Adu","Ade"};
        try {
            cetakElemenArray(namaSiswa,2);
            cetakElemenArray(namaSiswa,3);
        } catch (Exception e) {
            System.out.println("Index tidak ditemukan");
        }

        Scanner S = new Scanner(System.in);
        int nilai = 0;
        try {
            nilai = S.nextInt();
        }catch (Exception e){
            System.out.println("Masukkan integer");
        }
        System.out.println("nilai:"+nilai);
    }
}
