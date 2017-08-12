package com.example;

/**
 * Created by hilmiat on 8/12/17.
 */

public class Pegawai implements CetakAble{
    //punya apa?
    protected String nama,alamat,nip;
    private double gaji_pokok = 3000000;
    public Pegawai(String nama, String alamat, String nip) {
        this.nama = nama;
        this.alamat = alamat;
        this.nip = nip;
    }
    //bisa apa?
    public void cetakBiodata(){
        System.out.println("Nama\t:"+this.nama);
        System.out.println("NIP\t:"+this.nip);
        System.out.println("Alamat\t:"+this.alamat);
    }
    public double hitungGaji(int jam_lembur){
        //gajipokok + (2 % gajipokok*jam_lembur);
        return this.gaji_pokok + (0.02 * this.gaji_pokok * jam_lembur);
    }

    @Override
    public String toString() {
        return "Pegawai bernama:"+this.nama;
    }

    @Override
    public void cetak() {
        System.out.println(this.toString());
    }
}
