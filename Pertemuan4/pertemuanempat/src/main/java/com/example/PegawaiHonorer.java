package com.example;

/**
 * Created by hilmiat on 8/12/17.
 */

public class PegawaiHonorer extends Pegawai{

    public PegawaiHonorer(String nama, String alamat) {
        super(nama, alamat, "honorer");
    }
    void cetakHonorer(){
        System.out.println("nama"+super.nama);
    }

}
