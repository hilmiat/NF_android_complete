package com.example.Bentuk;

/**
 * Created by hilmiat on 8/12/17.
 */

public class PersegiPanjang implements Bentuk2D {
    private float panjang,lebar = 0f;

    public PersegiPanjang(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public float getLuas() {
        return this.panjang * this.lebar;
    }

    @Override
    public float getKeliling() {
        return 2f * (this.panjang+this.lebar);
    }

    @Override
    public String getNamaBentuk() {
        return "Persegi Panjang";
    }
    @Override
    public String getNamaAplikasi() {
        return "Aplikasi bentuk 2d";
    }
}
