package com.example;

public class MyClass {
    public static void main(String[] args) {
        //deklarasi variable nilai_siswa (5 element)
        double[] nilai_siswa = new double[5];
        //mengakses array
        nilai_siswa[0] = 40.9;
        nilai_siswa[1] = 70;
        System.out.println("nilai_siswa index ke-1:"
                +nilai_siswa[1]);//70.0

        System.out.println("nilai_siswa index ke-2:"+nilai_siswa[2]);
        //isinya 0

        //deklarasi sekaligus inisialisasi
        String[] nama_siswa = {"Adi","Ade","Adu","Ida","Edo"};
        System.out.println("nama_siswa ke-4:"+nama_siswa[4]); //Edo

        String[] nama_siswa2 = nama_siswa;
        nama_siswa2[4]="Oda";
        System.out.println("nama_siswa ke-4:"+nama_siswa[4]); //Oda

        //looping for
        for(int idx=0;idx<nama_siswa.length;idx++){
            System.out.println("nama_siswa ke-"+idx+":"+nama_siswa[idx]);
        }
        System.out.println("Mencetak dengan for spesial:");
        //special for
        for(String siswa:nama_siswa){
            System.out.println(siswa);
        }
        for(double nil:nilai_siswa){
            System.out.print(nil+",");
        }
        System.out.println("\nNested for");
        //nested for
        for(int i=0;i<5;i++){
            for(int x=0;x<3;x++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
