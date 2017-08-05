package com.example;

/**
 * Created by hilmiat on 8/5/17.
 */

public class UseAccount {
    public static void main(String[] args) {
        Account ac = new Account();
        ac.setNoAccount("007");
        ac.deposit(1000);
//        ac.saldo = 1000000;
        System.out.println("Saldo:"+ac.cekSaldo());
        ac.sayHello();

        Account ac2 = new Account();
        ac2.sayHello();

        Account.salam();

        Account ac3 = new Account("009",100);
    }
}
