package com.example;

/**
 * Created by hilmiat on 7/29/17.
 */

public class DemoConditional {
    public static char getGrade(int nilai){
        char grade = 'D';
        if(nilai > 85){
            grade = 'A';
        }else if(nilai > 69){
            grade = 'B';
        }else if(nilai >= 60){
            grade = 'C';
        }
        return grade;
    }
    public static void main(String[] args) {
        int[] nilai_siswa = {78,90,89,68,77};
        OperasiArray.cetakArray(nilai_siswa);
        //100-86 A,70-85 B,60-69 C,0-59 D
        //kalau D tidak lulus, A,B,C lulus
        for(int n:nilai_siswa){
            System.out.println("Nilai "+n+",garade-nya:"+getGrade(n));
        }
    }
}
