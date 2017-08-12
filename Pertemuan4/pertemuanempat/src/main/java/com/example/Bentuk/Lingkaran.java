package com.example.Bentuk;

/**
 * Created by hilmiat on 8/12/17.
 */

public class Lingkaran implements Bentuk2D{
    private float jari =  0f;

    public Lingkaran(float jari) {
        this.jari = jari;
    }

    @Override
    public float getLuas() {
        return PHI * this.jari * this.jari;
    }

    @Override
    public float getKeliling() {
        return 2f * PHI * this.jari;
    }

    @Override
    public String getNamaBentuk() {
        return "Lingkaran";
    }

    @Override
    public String getNamaAplikasi() {
        return "Aplikasi bentuk 2d";
    }
}
