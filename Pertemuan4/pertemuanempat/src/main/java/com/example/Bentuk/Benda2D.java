package com.example.Bentuk;

/**
 * Created by hilmiat on 8/12/17.
 */

public class Benda2D {
    public static void main(String[] args) {
        Lingkaran l =
           new Lingkaran(8f);
        PersegiPanjang p =
           new PersegiPanjang(7.2f,4.5f);
        BujurSangkar b =
           new BujurSangkar(5f);

        Bentuk2D[] bentuk2d =
                {l,p,b};

        for(Bentuk2D ben: bentuk2d){
            System.out.println("Luas "
                    +ben.getNamaBentuk()
                    +" : "
                    +ben.getLuas());
        }
    }
}
