package com.example;

/**
 * Created by hilmiat on 8/12/17.
 */

public class DemoPegawai {
    public static void main(String[] args) {
        //buat pegawai
        Pegawai p = new Pegawai("Joni","Bogor","908798");

//        Pegawai p2 = new Pegawai("a","b","89"){
//            @Override
//            public double hitungGaji(int jam_lembur) {
//               return 500000;
//            }
//        };

        p.cetakBiodata();
        double gajiBulanJan = p.hitungGaji(1);
        System.out.println("Gaji bulan Januari:"+gajiBulanJan);

        PegawaiHonorer ph = new PegawaiHonorer("Ilham","Jakarta");
        ph.cetakBiodata();

        System.out.println("isi obj p:"+p);

    }
}
