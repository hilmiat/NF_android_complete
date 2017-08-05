package com.example;

/**
 * Created by hilmiat on 8/5/17.
 */

public class Account {
    //property/variable
    private String no_acc = "";
    private double saldo = 0;
    public static String nama_bank = "BANK ROOT";
    //method
    public void setNoAccount(String no_acc){
        this.no_acc = no_acc;
    }
    public void deposit(double uang){
        this.saldo = this.saldo + uang;
    }
    public void withdraw(double uang){
        this.saldo = this.saldo - uang;
    }
    public void transfer(Account ac_tujuan, double uang){
        ac_tujuan.deposit(uang);
        this.withdraw(uang);
    }
    public double cekSaldo(){
        return this.saldo;
    }
    public void sayHello(){
        System.out.println("Helooo...");
    }
    public static void salam(){
        System.out.println("Assalamualaikum..selamat datang di "+nama_bank);
    }

    public Account(String no_acc, double saldo) {
        this.no_acc = no_acc;
        this.saldo = saldo;
    }

    public Account() {

    }
}
