package com.example.Bentuk;

/**
 * Created by hilmiat on 8/12/17.
 */

public class BujurSangkar implements Bentuk2D {
    private float sisi = 0f;

    public BujurSangkar(float sisi) {
        this.sisi = sisi;
    }

    @Override
    public float getLuas() {
        return this.sisi * this.sisi;
    }

    @Override
    public float getKeliling() {
        return 4f * this.sisi;
    }

    @Override
    public String getNamaBentuk() {
        return "BujurSangkar";
    }
    @Override
    public String getNamaAplikasi() {
        return "Aplikasi bentuk 2d";
    }
}
