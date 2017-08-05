package com.example;

public class MyClass {
    public static void main(String[] args) {
        //membuat objek dari kelas Siswa dgn nama s1
        //untuk membuat objek, gunakan keyword new
        Siswa s1 = new Siswa();
        //mengakses property (variable/"punya apa?")
        s1.nama = "Amir";
        s1.NIS = "09876";
        s1.nilai = 89.5f;

        System.out.println("Nama\t: "+s1.nama);
        System.out.println("NIS\t: "+s1.NIS);
        System.out.println("Nilai\t: "+s1.nilai);

        Siswa s2 = new Siswa();
        System.out.println("Nama s2\t: "+s2.nama);
        s2.nama="Wati";
        System.out.println("Nama s2\t: "+s2.nama);

        Siswa s3 = s2;
        System.out.println("Nama s3\t: "+s3.nama);
        s3.nama = "Ina";
        System.out.println("Nama s2\t: "+s2.nama);

        //cloning
        Siswa s4 = new Siswa();
        s4.nama = s2.nama;

        float nilai_s1 = s1.cekNilai();
        System.out.println("Nilai s1:"+nilai_s1);
        System.out.println("Nilai s2:"+s2.cekNilai());
        System.out.println("Nilai s3:"+s3.cekNilai());
    }
}
