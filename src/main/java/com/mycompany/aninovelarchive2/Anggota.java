package com.mycompany.aninovelarchive2;

public class Anggota {
    private String npm;
    private String nama;

    public Anggota(String npm, String nama) {
        this.npm = npm;
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }
}